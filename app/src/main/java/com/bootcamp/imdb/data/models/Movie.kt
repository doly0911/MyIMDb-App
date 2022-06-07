package com.bootcamp.imdb.data.models

data class Movie(
        var title: String = "",
        var year: String = "",
        var topCast: String = "",
        var category: String = "",
        var description: String = "",
        var rating: Float = 0f,
        var image: Int = 0
)
