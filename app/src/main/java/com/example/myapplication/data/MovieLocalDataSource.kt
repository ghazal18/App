package com.example.myapplication.data

import androidx.lifecycle.LiveData
import com.example.myapplication.data.database.DaoOfMovie
import com.example.myapplication.data.database.DaoOfMovieDetail
import com.example.myapplication.data.database.DaoOfUpComingResult
import com.example.myapplication.model.Movie
import com.example.myapplication.model.MovieDetail
import com.example.myapplication.model.UpComingResult

class MovieLocalDataSource(val movieDao: DaoOfMovie,val movieDetailDao: DaoOfMovieDetail, val upComingResultDao: DaoOfUpComingResult ) {

        suspend fun insertAllMovie(movieList: List<Movie>){
                movieDao.insertAll(movieList)
        }

        suspend fun getMovieList(): List<Movie>{
                return movieDao.getMovieList()
        }

        suspend fun updateMovieList(movieList: List<Movie>){
                movieDao.updateMovieList(movieList)
        }

        suspend fun getMovieListSize():Int{
               return movieDao.getMovieListSize()
        }

        suspend fun getMovieDetail(id:Int): MovieDetail{
                return movieDetailDao.getMovieDetail(id)
        }

        suspend fun saveMovieDetail(movie: MovieDetail){
                movieDetailDao.saveMovieDetail(movie)
        }

        suspend fun insertAllUpComingMovie(upComingMovieList: List<UpComingResult>){
                upComingResultDao.insertAllUpComingMovie(upComingMovieList)
        }

        suspend fun getUpComingMovieList():List<UpComingResult>{
                return upComingResultDao.getUpComingMovieList()
        }


}