package com.bootcamp.imdb.domain.movie


import com.bootcamp.imdb.data.remote.models.Movie
import com.bootcamp.imdb.data.remote.models.MovieList


interface MovieRepository {
    suspend fun findTopRatedMovies(): MovieList
    suspend fun findMovie(query: String): MovieList
    suspend fun getDetailsMovie(id: Int): Movie
}