package com.bootcamp.imdb.ui.movie

import android.util.Log
import androidx.lifecycle.*
import com.bootcamp.imdb.data.remote.models.Movie
import com.bootcamp.imdb.data.remote.models.MovieList
import com.bootcamp.imdb.data.repositories.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.Exception

class MovieViewModel (private val repo: MovieRepository): ViewModel() {

    private val viewModelJob = Job()
    private val coroutineScope  = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _moviesList = MutableLiveData<MovieList?>()
    val moviesList: LiveData<MovieList?>
        get() = _moviesList


//    fun fetchPopularMovie() = liveData(Dispatchers.IO) {
//        emit(Result.loading())
//        try {
//            emit(repo.findPopularMovies())
//        } catch (e:Exception){
//            emit(Result.Failure(e))
//        }
//    }

    //@TODO Implementar mensaje de error
    fun getPopularMovies(){
        coroutineScope.launch {
            try{
                _moviesList.value = repo.findPopularMovies()
            }catch (e : Exception) {
                Log.d("MovieListViewModel", "Error en getPopularMovies()", e)
            }
        }
    }

}

class MovieViewModelFactory(private val repo:MovieRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
    }
}
