package com.bootcamp.imdb.data.repositories

import com.bootcamp.imdb.data.remote.models.Movie
import com.bootcamp.imdb.data.remote.dataSources.MovieRemoteDataSource

class MovieRepositoryImpl(private val dataSource: MovieRemoteDataSource): MovieRepository {

    override suspend fun findPopularMovies(): List<Movie> = dataSource.findPopularMovies()

    override suspend fun findAllMovies(): List<Movie> = dataSource.findAllMovies()

}