package com.example.myapplication.data

import com.example.myapplication.data.network.ApiService
import com.example.myapplication.data.network.MovieApi
import com.example.myapplication.domin.Resource
import com.example.myapplication.domin.Status
import com.example.myapplication.model.*
import retrofit2.Response
import java.lang.Exception

class MovieRemoteDataSource (val apiService: ApiService){

    suspend fun getMovie(page: Int):List<Movie>{
        return apiService.getMovies(page).results
    }
    suspend fun searchMovie(query:String):Resource<List<Movie>>{
        var result = Resource<List<Movie>>(Status.LOADING, null)

        try {
            var response = apiService.searchMovie(query = query)
            if (response.isSuccessful){
                //TODO
                result.data = response.body()?.results as List<Movie>
                result.status = Status.SUCCESS

            }else
                return Resource(Status.ERROR, null, response.message())
        }
        catch (ex: Exception){
            return Resource(Status.ERROR, null, ex.message)
        }
        return result


//        return apiService.searchMovie(query=query).results
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