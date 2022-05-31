package com.example.myapplication.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MovieEntity::class, MovieDetailEntity::class, UpComingResultEntity::class], version = 1)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun MovieEntityDao(): DaoOfMovieEntity
    abstract fun MovieDetailEntityDao(): DaoOfMovieDetailEntity
    abstract fun UpComingResultEntityDao(): DaoOfUpComingResultEntity

    companion object{
        var     INSTANCE: MovieDatabase? = null
        fun getDatabase(context: Context): MovieDatabase?{
            if (INSTANCE == null){
                synchronized(MovieDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        MovieDatabase::class.java,"myDb")
                        .allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }
}