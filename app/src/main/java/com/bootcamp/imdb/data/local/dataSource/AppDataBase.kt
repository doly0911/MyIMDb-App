package com.bootcamp.imdb.data.local.dataSource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bootcamp.imdb.data.local.models.MovieEntity
import com.bootcamp.imdb.domain.local.MovieDAO

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)

abstract class AppDataBase:RoomDatabase() {

    abstract fun movieDao(): MovieDAO

    companion object {

        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext, AppDataBase::class.java, "movie_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return  instance
            }
        }
    }

}