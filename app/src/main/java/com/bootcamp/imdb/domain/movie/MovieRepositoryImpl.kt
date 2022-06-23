package com.bootcamp.imdb.domain.movie

import com.bootcamp.imdb.data.remote.dataSources.MovieRemoteDataSource
import com.bootcamp.imdb.data.remote.models.Movie
import com.bootcamp.imdb.data.remote.models.MovieList
import com.bootcamp.imdb.domain.movie.MovieRepository

class MovieRepositoryImpl(private val dataSource: MovieRemoteDataSource) : MovieRepository {

    override suspend fun findTopRatedMovies(): MovieList = dataSource.findTopRatedMovies()

    override suspend fun findMovie(query: String): MovieList = dataSource.findMovie(query)

    override suspend fun getDetailsMovie(idMovie: Int): Movie = dataSource.getDetailsMovie(idMovie)
}