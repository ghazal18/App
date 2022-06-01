package com.example.myapplication.data

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.myapplication.model.Movie
import com.example.myapplication.model.MovieDetail
import com.example.myapplication.model.UpComingResult
import com.example.myapplication.model.VideoResult

class MovieRepository (val movieRemoteDataSource:MovieRemoteDataSource, val movieLocalDataSource: MovieLocalDataSource){
    
    suspend fun getMovie():List<Movie>{
        movieLocalDataSource.insertAllMovie(movieRemoteDataSource.getMovie())
        return movieRemoteDataSource.getMovie()

    }
    suspend fun searchMovie(query:String):List<Movie>{
       try {
           if (movieLocalDataSource.getMovieListSize() == 0 ){
               movieLocalDataSource.insertAllMovie(movieRemoteDataSource.searchMovie(query))
           }else{
               movieLocalDataSource.updateMovieList(movieRemoteDataSource.searchMovie(query))
           }

           return movieRemoteDataSource.searchMovie(query)
       } catch (ex:Exception){
           return movieLocalDataSource.getMovieList()
       }

    }
    suspend fun upComingMovieList():List<UpComingResult>{
        return movieRemoteDataSource.upComingMovies()
    }
    suspend fun getMovieDetail(id:Int):MovieDetail{
        return movieRemoteDataSource.MovieDetail(id)
    }
    suspend fun getVideoOfMovie(id:Int):List<VideoResult>{
        return movieRemoteDataSource.getVideoOfMovie(id)
    }



}