package com.example.myapplication.data.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DaoOfMovieEntity {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg MovieList: MovieEntity)

    @Query("SELECT * fROM MovieEntity")
    fun getMovieList(): LiveData<List<MovieEntity>>

    @Update
    suspend fun updateMovieList(MovieList: List<MovieEntity>)

}