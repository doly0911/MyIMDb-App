package com.bootcamp.imdb.data.remote.dataSources

import com.bootcamp.imdb.data.remote.models.MovieList
import com.bootcamp.imdb.data.repositories.WebService
import com.bootcamp.imdb.utils.AppConstants

class MovieRemoteDataSource (private val webService: WebService) {
    suspend fun findPopularMovies(): MovieList = webService.findPopularMovies(AppConstants.API_KEY)
    suspend fun findMovie(query: String): MovieList = webService.findMovie(AppConstants.API_KEY, query)

}