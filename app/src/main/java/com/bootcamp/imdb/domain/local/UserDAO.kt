package com.bootcamp.imdb.domain.local

import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserDAO {
    @Query(value = "SELECT * from user_table where email = :email AND password = :password LIMIT 1")
    fun authenticate(email : String, password : String) : UserDAO?
}