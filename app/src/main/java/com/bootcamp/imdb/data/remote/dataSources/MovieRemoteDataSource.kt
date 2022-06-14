package com.bootcamp.imdb.data.remote.dataSources

import com.bootcamp.imdb.data.remote.models.Movie
import com.bootcamp.imdb.data.repositories.WebService
import com.bootcamp.imdb.utils.AppConstants

class MovieRemoteDataSource (private val webService: WebService) {
    suspend fun findPopularMovies(): List<Movie> = webService.findPopularMovies(AppConstants.API_KEY)
    suspend fun findAllMovies(): List<Movie> = webService.findAllMovies(AppConstants.API_KEY)

}