package com.example.myapplication.ui.movieDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domin.Container
import com.example.myapplication.model.MovieDetail
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlin.math.log

class DetailViewModel :ViewModel() {
    var filmLD =  MutableLiveData<MovieDetail>()
//
//    init {
//        getMovieDetail()
//    }

    fun getMovieDetail(id:Int):LiveData<MovieDetail>{
        viewModelScope.launch {
            try {
                filmLD.value = Container.movieRepository.getMovieDetail(id)
            }catch (e:Exception){
                Log.d("ERROR","not loaded")
            }

        }
        return filmLD
    }


}