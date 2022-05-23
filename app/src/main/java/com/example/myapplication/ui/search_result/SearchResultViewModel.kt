package com.example.myapplication.ui.search_result

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domin.Container
import com.example.myapplication.model.Movie
import kotlinx.coroutines.launch

class SearchResultViewModel: ViewModel(){
    val searchedList =  MutableLiveData<List<Movie>>()

    fun searchMovieList(query:String){
        viewModelScope.launch {
            val list = Container.movieRepository.searchMovie(query)
            searchedList.value = list
        }
    }
}