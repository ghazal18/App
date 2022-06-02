package com.example.myapplication.ui.video_webview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.MovieRepository
import com.example.myapplication.domin.Container
import com.example.myapplication.model.VideoResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowVideoViewModel @Inject constructor(private val repo : MovieRepository): ViewModel() {
    var videoList = MutableLiveData<List<VideoResult>>()

    fun getVideo(id:Int):LiveData<List<VideoResult>>{
        viewModelScope.launch {
            videoList.value= repo.getVideoOfMovie(id)
            }
        return videoList
    }

}