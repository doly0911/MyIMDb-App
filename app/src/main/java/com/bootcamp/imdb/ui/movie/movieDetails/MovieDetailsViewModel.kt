package com.bootcamp.imdb.ui.movie.movieDetails

import android.util.Log
import androidx.lifecycle.*
import com.bootcamp.imdb.data.remote.models.Movie
import com.bootcamp.imdb.domain.movie.MovieRepository
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val repo: MovieRepository): ViewModel() {

    private val _movieDetails = MutableLiveData<Movie?>()
    val movieDetails: LiveData<Movie?>
        get() = _movieDetails

    fun getDetails(idMovie: Int){
        viewModelScope.launch {
            try {
                _movieDetails.value = repo.getDetailsMovie(idMovie)
            } catch (e: Exception) {
                Log.d("MovieDetailsModel", "error: ", e)
            }
        }
    }

    class MovieDetailsViewModelFactory(private val repo: MovieRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return  modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
        }
    }
}
