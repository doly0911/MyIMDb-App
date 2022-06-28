package com.bootcamp.imdb.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int= -1,

    @ColumnInfo(name = "email")
    val email: String = "",

    @ColumnInfo(name = "password")
    val password: String = ""
)