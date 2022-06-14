package com.bootcamp.imdb.data.repositories


import com.bootcamp.imdb.data.remote.models.MovieList


interface MovieRepository {
    suspend fun findPopularMovies(): MovieList
    suspend fun findAllMovies(): MovieList
}