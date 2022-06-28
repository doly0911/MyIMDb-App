package com.bootcamp.imdb.data.local.dataSource

import com.bootcamp.imdb.data.local.models.MovieEntity
import com.bootcamp.imdb.data.local.models.toMovieList
import com.bootcamp.imdb.data.remote.models.MovieList
import com.bootcamp.imdb.domain.local.MovieDAO

class MovieLocalDataSource(private val movieDAO: MovieDAO) {

    suspend fun getTopRatedMovies(): MovieList {
        return movieDAO.getMovies().filter { it.movieType == "toprated" }.toMovieList()
    }

    suspend fun saveMovie(movieEntity: MovieEntity){
        movieDAO.saveMovie(movieEntity)
    }
}