package com.example.myapplication.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.model.UpComingResult

@Dao
interface DaoOfUpComingResult {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUpComingMovie(UpComingMovieList: List<UpComingResult>)

    @Query("SELECT * fROM UpComingResult")
    suspend fun getUpComingMovieList():List<UpComingResult>
}