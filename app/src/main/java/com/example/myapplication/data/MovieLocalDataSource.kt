package com.example.myapplication.data

import androidx.lifecycle.LiveData
import com.example.myapplication.data.database.DaoOfMovie
import com.example.myapplication.data.database.DaoOfMovieDetail
import com.example.myapplication.data.database.DaoOfUpComingResult
import com.example.myapplication.data.database.MovieDatabase
import com.example.myapplication.model.Movie
import com.example.myapplication.model.MovieDetail
import com.example.myapplication.model.UpComingResult
import javax.inject.Inject

class MovieLocalDataSource @Inject constructor (private val database: MovieDatabase ) {


        suspend fun insertAllMovie(movieList: List<Movie>){
                database.MovieDao().insertAll(movieList)
//                movieDao.insertAll(movieList)
        }

        suspend fun getMovieList(): List<Movie>{
                return database.MovieDao().getMovieList()
        }

        suspend fun updateMovieList(movieList: List<Movie>){
                database.MovieDao().updateMovieList(movieList)
        }

        suspend fun getMovieListSize():Int{
               return database.MovieDao().getMovieListSize()
        }

        suspend fun getMovieDetail(id:Int): MovieDetail{
                return database.MovieDetailDao().getMovieDetail(id)
        }

        suspend fun saveMovieDetail(movie: MovieDetail){
                database.MovieDetailDao().saveMovieDetail(movie)
        }

        suspend fun insertAllUpComingMovie(upComingMovieList: List<UpComingResult>){
                database.UpComingResultDao().insertAllUpComingMovie(upComingMovieList)
        }

        suspend fun getUpComingMovieList():List<UpComingResult>{
                return  database.UpComingResultDao().getUpComingMovieList()
        }


}