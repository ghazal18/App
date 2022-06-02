package com.example.myapplication.data

import com.example.myapplication.data.network.ApiService
import com.example.myapplication.data.network.MovieApi
import com.example.myapplication.model.Movie
import com.example.myapplication.model.MovieDetail
import com.example.myapplication.model.UpComingResult
import com.example.myapplication.model.VideoResult
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor (val apiService: ApiService){

    suspend fun getMovie():List<Movie>{
        return apiService.getMovies().results
    }
    suspend fun searchMovie(query:String):List<Movie>{
        return apiService.searchMovie(query=query).results
    }
    suspend fun MovieDetail(id:Int):MovieDetail{
        return apiService.MovieDetail(movieId = id)
    }
    suspend fun upComingMovies():List<UpComingResult>{
        return apiService.upComingMovies().results
    }

        suspend fun getVideoOfMovie(id:Int):List<VideoResult>{
        return apiService.videoOfMovie(movieId = id).results
    }

}