package com.bootcamp.imdb.data.remote.dataSources.movie

import com.bootcamp.imdb.data.remote.models.Movie
import com.bootcamp.imdb.data.remote.models.MovieList

interface IMovieRemoteDataSource {
    suspend fun findTopRatedMovies(): MovieList

    suspend fun findMovie(query: String): MovieList

    suspend fun getDetailsMovie(idMovie: Int): Movie
}