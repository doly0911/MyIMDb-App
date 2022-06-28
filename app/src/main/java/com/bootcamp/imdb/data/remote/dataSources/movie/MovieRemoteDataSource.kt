package com.bootcamp.imdb.data.remote.dataSources.movie

import com.bootcamp.imdb.data.remote.WebService
import com.bootcamp.imdb.data.remote.models.Movie
import com.bootcamp.imdb.data.remote.models.MovieList
import com.bootcamp.imdb.utils.AppConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRemoteDataSource (private val webService: WebService) {
    suspend fun findTopRatedMovies(): MovieList {
        return  withContext(Dispatchers.IO) {
            webService.findTopRatedMovies(AppConstants.API_KEY)
        }
    }

    suspend fun findMovie(query: String): MovieList = webService.findMovie(AppConstants.API_KEY, query)

    suspend fun getDetailsMovie(idMovie:Int): Movie = webService.getDetailsMovie(idMovie, AppConstants.API_KEY)

}