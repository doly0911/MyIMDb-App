package com.bootcamp.imdb.utils

import androidx.lifecycle.LiveData


sealed class Result<out T> {
    class loading<out T>: Result<T>()
    data class Success<out T>(val data: T): Result<T>()
    data class Failure (val expection: Exception): Result<Nothing>()

}