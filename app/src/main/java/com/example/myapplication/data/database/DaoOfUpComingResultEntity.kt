package com.example.myapplication.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DaoOfUpComingResultEntity {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUpComingMovie(vararg UpComingMovieList: UpComingResultEntity)

    @Query("SELECT * fROM MovieEntity")
    suspend fun getUpComingMovieList(): LiveData<List<UpComingResultEntity>>
}