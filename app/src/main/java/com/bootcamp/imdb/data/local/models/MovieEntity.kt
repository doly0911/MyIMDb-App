package com.bootcamp.imdb.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bootcamp.imdb.data.remote.models.Movie
import com.bootcamp.imdb.data.remote.models.MovieList

@Entity (tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey
    val id: Int= -1,

    @ColumnInfo(name = "adult")
    val adult: Boolean = false,

//    @ColumnInfo(name = "genre_ids")
//    @Ignore val generoId: List<Int> = listOf(),

    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String = "",

    @ColumnInfo(name = "original_title")
    val originalTitle: String = "",

    @ColumnInfo(name = "original_language")
    val originalLanguage: String = "",

    @ColumnInfo(name = "overview")
    val overview: String = "",

    @ColumnInfo(name = "popularity")
    val popularity: Double = -1.0,

    @ColumnInfo(name = "poster_path")
    val posterPath: String ="",

    @ColumnInfo(name = "release_date")
    val releaseDate: String = "",

    @ColumnInfo(name = "title")
    val title: String= "",

    @ColumnInfo(name = "video")
    val video: Boolean = false,

    @ColumnInfo(name = "vote_average")
    val voteAverage: Double = -1.0,

    @ColumnInfo(name = "vote_count")
    val voteCount: Int = -1,

    @ColumnInfo(name = "movie_type")
    val movieType: String = ""
)

 fun List<MovieEntity>.toMovieList(): MovieList {
     val resultList = mutableListOf<Movie>()
     this.forEach { movieEntity ->
         resultList.add(movieEntity.toMovie())
     }
     return MovieList(resultList)
 }

fun MovieEntity.toMovie(): Movie = Movie (
    this.id,
    this.adult,
    this.backdropPath,
    this.originalTitle,
    this.originalLanguage,
    this.overview,
    this.popularity,
    this.posterPath,
    this.releaseDate,
    this.title,
    this.video,
    this.voteAverage,
    this.voteCount,
    this.movieType
)
