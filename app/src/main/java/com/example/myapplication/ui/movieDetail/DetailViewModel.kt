package com.example.myapplication.ui.movieDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.MovieRepository
import com.example.myapplication.domin.Container
import com.example.myapplication.model.MovieDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class DetailViewModel @Inject constructor(private val repo : MovieRepository) :ViewModel() {
    var filmLD =  MutableLiveData<MovieDetail>()
//
//    init {
//        getMovieDetail()
//    }

    fun getMovieDetail(id:Int):LiveData<MovieDetail>{
        viewModelScope.launch {
            try {
                filmLD.value = repo.getMovieDetail(id)
            }catch (e:Exception){
                Log.d("ERROR","not loaded")
            }

        }
        return filmLD
    }


}