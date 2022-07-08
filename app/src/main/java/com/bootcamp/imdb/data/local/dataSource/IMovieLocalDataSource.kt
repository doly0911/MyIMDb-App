package com.bootcamp.imdb.data.local.dataSource

import com.bootcamp.imdb.data.local.models.MovieEntity
import com.bootcamp.imdb.data.remote.models.MovieList

interface IMovieLocalDataSource {
    suspend fun getTopRatedMovies(): MovieList

    suspend fun saveMovie(movieEntity: MovieEntity)
}