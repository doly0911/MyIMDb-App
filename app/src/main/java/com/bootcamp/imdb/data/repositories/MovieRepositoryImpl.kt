package com.bootcamp.imdb.data.repositories

import com.bootcamp.imdb.data.remote.dataSources.MovieRemoteDataSource
import com.bootcamp.imdb.data.remote.models.MovieList

class MovieRepositoryImpl(private val dataSource: MovieRemoteDataSource): MovieRepository {

    override suspend fun findPopularMovies(): MovieList = dataSource.findPopularMovies()

    override suspend fun findMovie(query: String): MovieList = dataSource.findMovie(query)

}