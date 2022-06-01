package com.example.myapplication.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.model.Movie

@Dao
interface DaoOfMovie {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg MovieList: Movie)

    @Query("SELECT * fROM Movie")
    fun getMovieList(): LiveData<List<Movie>>

    @Update
    suspend fun updateMovieList(MovieList: List<Movie>)

    @Query("SELECT COUNT(id) fROM Movie")
    suspend fun getMovieListSize(): Int
}