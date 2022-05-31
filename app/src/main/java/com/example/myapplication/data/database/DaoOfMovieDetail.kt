package com.example.myapplication.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.model.MovieDetail

@Dao
interface DaoOfMovieDetail {

    @Query("SELECT * FROM MovieDetail WHERE id = :id ")
    suspend fun getMovieDetail(id:Int): MovieDetail

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovieDetail(Movie: MovieDetail)
}