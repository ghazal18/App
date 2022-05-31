package com.example.myapplication.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class MovieEntity(
    @PrimaryKey(autoGenerate = true) val number:Int,
//    val genre_ids: List<Int>,

    val id: Int,

    val overview: String,

    val poster_path: String,

    val title: String,

    val video: Boolean,
)