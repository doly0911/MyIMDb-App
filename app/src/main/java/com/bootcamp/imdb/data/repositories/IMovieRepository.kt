package com.bootcamp.imdb.data.repositories

import com.bootcamp.imdb.data.models.Movie

interface IMovieRepository {
    fun findBestMovies(): List<Movie>
    fun findAllMovies(): List<Movie>
}