package com.example.myapplication.ui.upComingMovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domin.Container
import com.example.myapplication.model.Movie
import com.example.myapplication.model.UpComingResult
import kotlinx.coroutines.launch

class UpComingMovieViewModel: ViewModel() {
    val upComingMovieList = MutableLiveData<List<UpComingResult>>()

    fun UpComingMovieList(){
        viewModelScope.launch {
            upComingMovieList.value = Container.movieRepository.upComingMovieList()
        }
    }

}