package com.example.myapplication.ui.movieList

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.MovieRepository
import com.example.myapplication.domin.Container
import com.example.myapplication.model.Movie
import kotlinx.coroutines.launch
import java.lang.Exception


enum class ApiStatus {
    Loading,
    Done,
    Error
}

class MovieListViewModel(val repo : MovieRepository) : ViewModel() {
    val status = MutableLiveData<ApiStatus>()
    val movieList = MutableLiveData<List<Movie>>()


    init {
      getMovie()

    }



    fun getMovie() {
        var list = listOf<Movie>()
        status.value = ApiStatus.Loading
        viewModelScope.launch {
            try {
                for (i in 0 .. 15){
                   list += repo.getMovie(i)
                }
                movieList.value = list
            }catch (e:Exception){
                status.value = ApiStatus.Error
                Log.d("ERROR","not loaded")
            }

        }
    }

}