package com.example.myapplication.ui.movieList

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domin.Container
import com.example.myapplication.model.Movie
import kotlinx.coroutines.launch
import java.lang.Exception


enum class ApiStatus {
    Loading,
    Done,
    Error
}

class MovieListViewModel : ViewModel() {
    val status = MutableLiveData<ApiStatus>()
    val movieList = MutableLiveData<List<Movie>>()


    init {
        getMovie()
    }

    fun getMovie() {
        status.value = ApiStatus.Loading
        viewModelScope.launch {
            try {
                val list = Container.movieRepository.getMovie()
                movieList.value = list
            }catch (e:Exception){
                Log.d("ERROR","not loaded")
            }

        }
    }

}