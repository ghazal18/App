package com.example.myapplication.ui.upComingMovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.MovieRepository
import com.example.myapplication.domin.Container
import com.example.myapplication.model.Movie
import com.example.myapplication.model.UpComingResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpComingMovieViewModel @Inject constructor(private val repo : MovieRepository): ViewModel() {
    val upComingMovieListLD = MutableLiveData<List<UpComingResult>>()

    init {
        UpComingMovieList()
    }

    fun UpComingMovieList(){
        viewModelScope.launch {
            var list = repo.upComingMovieList()
            upComingMovieListLD.value = list
        }
    }

}