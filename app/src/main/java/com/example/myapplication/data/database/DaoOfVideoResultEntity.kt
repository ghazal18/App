package com.example.myapplication.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface DaoOfVideoResultEntity {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllVideo(vararg videoList:VideoResultEntity)

    @Query("SELECT * fROM VideoResultEntity")
    suspend fun getVideoList(): LiveData<List<VideoResultEntity>>

}