package com.example.myapplication.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.model.Movie

@Dao
interface DaoOfMovie {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(MovieList: List<Movie>)
    //(vararg MovieList: Movie)

    @Query("SELECT * fROM Movie")
    suspend fun getMovieList(): List<Movie>

    @Update
    suspend fun updateMovieList(movieList: List<Movie>)

    @Query("SELECT COUNT(id) fROM Movie")
    suspend fun getMovieListSize(): Int
}