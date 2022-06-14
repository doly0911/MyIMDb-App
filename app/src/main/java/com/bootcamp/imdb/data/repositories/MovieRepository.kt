package com.bootcamp.imdb.data.repositories

import com.bootcamp.imdb.data.remote.models.Movie


interface MovieRepository {
    suspend fun findPopularMovies(): List<Movie>
    suspend fun findAllMovies(): List<Movie>
}