package com.bootcamp.imdb.domain

import com.bootcamp.imdb.data.remote.dataSources.movie.IMovieRemoteDataSource
import com.bootcamp.imdb.data.remote.models.Movie
import com.bootcamp.imdb.data.remote.models.MovieList

class FakeMovieRemoteDataSource(var movies: MutableList<Movie>): IMovieRemoteDataSource {

    override suspend fun findTopRatedMovies(): MovieList {
        return MovieList(movies)
    }

    override suspend fun findMovie(query: String): MovieList {
        val result = movies.filter{ it.title.contains(query) }
        return MovieList(result)
    }

    override suspend fun getDetailsMovie(idMovie: Int): Movie {
        TODO("Not yet implemented")
    }
}