package com.example.myapplication.ui.search_result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.MovieRepository
import com.example.myapplication.domin.Container
import com.example.myapplication.model.Movie
import kotlinx.coroutines.launch

class SearchResultViewModel(val repo : MovieRepository): ViewModel(){
    val searchedList =  MutableLiveData<List<Movie>>()

    fun searchMovieList(query:String):LiveData<List<Movie>>{
        viewModelScope.launch {
            var list = repo.searchMovie(query)
            if (list == null){
                searchedList.value = repo.search("%"+query + "%")
            }else{
                searchedList.value = list
            }
        }
        return searchedList
    }


}