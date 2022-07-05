package com.bootcamp.imdb.data.remote.models

import com.bootcamp.imdb.data.local.models.MovieEntity

data class Movie(
    val id: Int= -1,
    val adult: Boolean = false,
    //val genre_ids: List<Int> = listOf(),
    val backdrop_path: String = "",
    val original_title: String = "",
    val original_language: String = "",
    val overview: String = "",
    val popularity: Double = -1.0,
    val poster_path: String ="",
    val release_date: String = "",
    val title: String= "",
    val video: Boolean = false,
    val vote_average: Double = -1.0,
    val vote_count: Int = -1,
    val movieType: String = ""
)

data class MovieList(
    val results: List<Movie> = listOf()
)

fun Movie.toMovieEntity(movieType: String): MovieEntity = MovieEntity(
    this.id,
    this.adult,
    this.backdrop_path,
    this.original_title,
    this.original_language,
    this.overview,
    this.popularity,
    this.poster_path,
    this.release_date,
    this.title,
    this.video,
    this.vote_average,
    this.vote_count,
    movieType = movieType
)
