package com.example.myapplication.data

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.myapplication.model.Movie
import com.example.myapplication.model.MovieDetail
import com.example.myapplication.model.UpComingResult
import com.example.myapplication.model.VideoResult

class MovieRepository (val movieRemoteDataSource:MovieRemoteDataSource, val movieLocalDataSource: MovieLocalDataSource){
    
    suspend fun getMovie(page: Int):List<Movie>{
        try {
            if (movieLocalDataSource.getMovieListSize() == 0 ){
                movieLocalDataSource.insertAllMovie(movieRemoteDataSource.getMovie(page))
            }else{
                movieLocalDataSource.updateMovieList(movieRemoteDataSource.getMovie(page))
            }
            return movieRemoteDataSource.getMovie(page)
        }catch (ex:Exception){
           return movieLocalDataSource.getMovieList()
        }
    }

    suspend fun search(word:String):List<Movie>{
        return movieLocalDataSource.search(word)
    }

    suspend fun searchMovie(query:String):List<Movie>?{
//       try {
//           if (movieLocalDataSource.getMovieListSize() == 0 ){
//               movieLocalDataSource.insertAllMovie(movieRemoteDataSource.searchMovie(query).data!!)
//           }else{
//               movieLocalDataSource.updateMovieList(movieRemoteDataSource.searchMovie(query).data!!)
//           }
//
//           return movieRemoteDataSource.searchMovie(query).data!!
//       } catch (ex:Exception){
//           return movieLocalDataSource.getMovieList()
//       }
            return movieRemoteDataSource.searchMovie(query).data
    }

    suspend fun upComingMovieList():List<UpComingResult>{
        try {
            movieLocalDataSource.insertAllUpComingMovie(movieRemoteDataSource.upComingMovies())
            return movieRemoteDataSource.upComingMovies()
        }catch (ex:Exception){
            return movieLocalDataSource.getUpComingMovieList()
        }
    }

    suspend fun getMovieDetail(id:Int):MovieDetail{
        try {
                movieLocalDataSource.saveMovieDetail(movieRemoteDataSource.MovieDetail(id))

            return movieRemoteDataSource.MovieDetail(id)
        }catch (ex:Exception){
            return movieLocalDataSource.getMovieDetail(id)
        }

    }
    suspend fun getVideoOfMovie(id:Int):List<VideoResult>{
            return movieRemoteDataSource.getVideoOfMovie(id)
    }



}