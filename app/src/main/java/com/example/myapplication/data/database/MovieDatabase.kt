package com.example.myapplication.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.model.Movie
import com.example.myapplication.model.MovieDetail
import com.example.myapplication.model.UpComingResult

@Database(entities = [Movie::class, MovieDetail::class, UpComingResult::class], version = 1)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun MovieDao(): DaoOfMovie
    abstract fun MovieDetailDao(): DaoOfMovieDetail
    abstract fun UpComingResultDao(): DaoOfUpComingResult

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