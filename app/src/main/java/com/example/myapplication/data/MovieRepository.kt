package com.example.myapplication.data

import com.example.myapplication.model.Movie
import com.example.myapplication.model.MovieDetail
import com.example.myapplication.model.UpComingResult

class MovieRepository (val movieRemoteDataSource:MovieRemoteDataSource){
    
    suspend fun getMovie():List<Movie>{
        return movieRemoteDataSource.getMovie()
    }
    suspend fun searchMovie(query:String):List<Movie>{
        return movieRemoteDataSource.searchMovie(query)
    }
    suspend fun upComingMovieList():List<UpComingResult>{
        return movieRemoteDataSource.upComingMovies()
    }
    suspend fun getMovieDetail(id:Int):MovieDetail{
        return movieRemoteDataSource.MovieDetail(id)
    }



}