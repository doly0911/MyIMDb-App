package com.bootcamp.imdb.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bootcamp.imdb.data.remote.models.MovieList
import com.bootcamp.imdb.domain.remote.movie.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel (private val repo: MovieRepository): ViewModel()  {
    private val viewModelJob = Job()
    private val coroutineScope  = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _moviesList = MutableLiveData<MovieList?>()
    val moviesList: LiveData<MovieList?>
        get() = _moviesList


    fun getPopularMovies() {
        coroutineScope.launch {
            try{
                _moviesList.value = repo.findTopRatedMovies()
            }catch (e : Exception) {
                Log.d("HomeViewModel", "error: ", e)
            }
        }
    }

    class HomeViewModelFactory(private val repo: MovieRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return  modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
        }
    }
}