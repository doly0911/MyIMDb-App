package com.bootcamp.imdb.domain.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bootcamp.imdb.data.local.models.MovieEntity

@Dao
interface MovieDAO {

    @Query(value = "SELECT * FROM movie_table" )
    suspend fun getMovies() : List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movie: MovieEntity)

}