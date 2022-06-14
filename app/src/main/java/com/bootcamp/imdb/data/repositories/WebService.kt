package com.bootcamp.imdb.data.repositories

import com.bootcamp.imdb.data.remote.models.Movie
import com.bootcamp.imdb.utils.AppConstants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("movie/popular")
    suspend fun findPopularMovies(@Query ("api_key") api_key: String): List<Movie>

    @GET("movie/now_playing")
    suspend fun findAllMovies(@Query ("api_key") api_key: String): List<Movie>

}

//Exponer el servicio Retrofit al resto de la app
object RetrofitClient {
    val webService: WebService by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}