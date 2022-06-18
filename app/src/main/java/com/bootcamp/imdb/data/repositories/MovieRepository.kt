package com.bootcamp.imdb.data.repositories


import com.bootcamp.imdb.data.remote.models.MovieList


interface MovieRepository {
    suspend fun findTopRatedMovies(): MovieList
    suspend fun findMovie(query: String): MovieList
}