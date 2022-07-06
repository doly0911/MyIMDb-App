package com.bootcamp.imdb.ui.movie.movieDetails

import android.util.Log
import androidx.lifecycle.*
import com.bootcamp.imdb.data.remote.models.Movie
import com.bootcamp.imdb.domain.remote.movie.MovieRepository
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val repo: MovieRepository): ViewModel() {

    private val _movieDetailsResponse = MutableLiveData<Movie?>()
    val movieDetailsResponse: LiveData<Movie?>
        get() = _movieDetailsResponse

    fun getDetails(idMovie: Int){
        viewModelScope.launch {
            try {
                _movieDetailsResponse.value = repo.getDetailsMovie(idMovie)
            } catch (e: Exception) {
                Log.d("MovieDetailsViewModel", "error: ", e)
            }
        }
    }

    class MovieDetailsViewModelFactory(private val repo: MovieRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return  modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
        }
    }
}
