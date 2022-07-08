package com.bootcamp.imdb.domain

import com.bootcamp.imdb.data.local.dataSource.IMovieLocalDataSource
import com.bootcamp.imdb.data.local.models.MovieEntity
import com.bootcamp.imdb.data.local.models.toMovie
import com.bootcamp.imdb.data.remote.models.Movie
import com.bootcamp.imdb.data.remote.models.MovieList

class FakeMovieLocalDataSource(var movies: MutableList<Movie> = mutableListOf()): IMovieLocalDataSource {

    override suspend fun getTopRatedMovies(): MovieList {
        return MovieList(movies)
    }

    override suspend fun saveMovie(movieEntity: MovieEntity) {
        movies.add(movieEntity.toMovie())
    }


}