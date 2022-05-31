package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class Movie(
//    @PrimaryKey(autoGenerate = true) val number:Int,
//    @Json(name = "genre_ids")
//    val genre_ids: List<Int>,
    @Json(name = "id")
    @PrimaryKey  val id: Int,
    @Json(name = "overview")
    val overview: String,
    @Json(name = "poster_path")
    val poster_path: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "video")
    val video: Boolean,

)
