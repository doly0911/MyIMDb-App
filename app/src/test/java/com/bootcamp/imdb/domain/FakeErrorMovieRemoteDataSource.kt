package com.bootcamp.imdb.domain

import com.bootcamp.imdb.data.remote.dataSources.movie.IMovieRemoteDataSource
import com.bootcamp.imdb.data.remote.models.Movie
import com.bootcamp.imdb.data.remote.models.MovieList
import java.net.UnknownHostException

class FakeErrorMovieRemoteDataSource : IMovieRemoteDataSource {

    override suspend fun findTopRatedMovies(): MovieList {
       throw UnknownHostException("connection error")
    }

    override suspend fun findMovie(query: String): MovieList {
        TODO("Not yet implemented")
    }

    override suspend fun getDetailsMovie(idMovie: Int): Movie {
        TODO("Not yet implemented")
    }
}