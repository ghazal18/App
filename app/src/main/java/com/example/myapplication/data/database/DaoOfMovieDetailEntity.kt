package com.example.myapplication.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DaoOfMovieDetailEntity {

    @Query("SELECT * FROM MovieDetailEntity WHERE id = :id ")
    suspend fun getMovieDetail(id:Int): MovieDetailEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovieDetail(Movie: MovieDetailEntity)
}