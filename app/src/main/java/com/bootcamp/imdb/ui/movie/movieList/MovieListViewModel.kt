package com.bootcamp.imdb.ui.movie.movieList

import android.util.Log
import androidx.lifecycle.*
import com.bootcamp.imdb.data.remote.models.MovieList
import com.bootcamp.imdb.domain.remote.movie.MovieRepository
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

    fun searchMovie(query: String){
        coroutineScope.launch {
            try{
                _moviesList.value = repo.findMovie(query)
            }catch (e : Exception) {
                Log.d("MovieListViewModel", "Error: ", e)
            }
        }
    }
}

class MovieViewModelFactory(private val repo: MovieRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
    }
}
