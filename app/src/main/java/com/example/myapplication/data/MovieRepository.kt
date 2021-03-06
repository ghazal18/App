package com.example.myapplication.data

import com.example.myapplication.model.Movie

class MovieRepository (val movieRemoteDataSource:MovieRemoteDataSource){
    
    suspend fun getMovie():List<Movie>{
        return movieRemoteDataSource.getMovie()
    }


}