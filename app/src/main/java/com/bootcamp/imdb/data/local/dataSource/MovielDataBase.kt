package com.bootcamp.imdb.data.local.dataSource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bootcamp.imdb.data.local.models.MovieEntity
import com.bootcamp.imdb.data.local.models.UserEntity
import com.bootcamp.imdb.domain.local.MovieDAO
import com.bootcamp.imdb.domain.local.UserDAO

@Database(entities = [MovieEntity::class, UserEntity::class], version = 1, exportSchema = false)

abstract class MovielDataBase:RoomDatabase() {

    abstract val movieDao: MovieDAO
    abstract val userDao: UserDAO

    companion object {

        private var INSTANCE: MovielDataBase? = null

        fun getInstance(context: Context): MovielDataBase {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext, MovielDataBase::class.java, "movie_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return  instance
            }
        }
    }

}