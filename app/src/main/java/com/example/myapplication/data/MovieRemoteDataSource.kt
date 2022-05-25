package com.example.myapplication.data

import com.example.myapplication.data.network.MovieApi
import com.example.myapplication.model.Movie
import com.example.myapplication.model.MovieDetail
import com.example.myapplication.model.UpComingResult
import com.example.myapplication.model.VideoResult

class MovieRemoteDataSource {

    suspend fun getMovie():List<Movie>{
        return MovieApi.retrofitService.getMovies().results
    }
    suspend fun searchMovie(query:String):List<Movie>{
        return MovieApi.retrofitService.searchMovie(query=query).results
    }
    suspend fun MovieDetail(id:Int):MovieDetail{
        return MovieApi.retrofitService.MovieDetail(movieId = id)
    }
    suspend fun upComingMovies():List<UpComingResult>{
        return MovieApi.retrofitService.upComingMovies().results
    }

    suspend fun getVideoOfMovie(id:Int):List<VideoResult>{
        return MovieApi.retrofitService.videoOfMovie(movieId = id).results
    }

}