package com.bootcamp.imdb.domain.remote.movie

import android.util.Log
import com.bootcamp.imdb.data.local.dataSource.MovieLocalDataSource
import com.bootcamp.imdb.data.remote.dataSources.movie.MovieRemoteDataSource
import com.bootcamp.imdb.data.remote.models.Movie
import com.bootcamp.imdb.data.remote.models.MovieList
import com.bootcamp.imdb.data.remote.models.toMovieEntity
import java.net.UnknownHostException

class MovieRepositoryImpl(private val RemoteDataSource: MovieRemoteDataSource,
                          private val localDataSource: MovieLocalDataSource) : MovieRepository {

    override suspend fun findTopRatedMovies(): MovieList {
        try{
            RemoteDataSource.findTopRatedMovies().results.forEach {movie ->
                localDataSource.saveMovie(movie.toMovieEntity("toprated"))
            }
        }catch (e: UnknownHostException){
            Log.d("MovieRepositoryImpl", "No internet connection, results from local")
        }
        return localDataSource.getTopRatedMovies()
    }

    override suspend fun findMovie(query: String): MovieList = RemoteDataSource.findMovie(query)

    override suspend fun getDetailsMovie(idMovie: Int): Movie = RemoteDataSource.getDetailsMovie(idMovie)
}