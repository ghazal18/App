package com.example.myapplication.model

import com.squareup.moshi.Json

data class Movie(
    @Json(name = "genre_ids")
    val genre_ids: List<Int>,
    @Json(name = "id")
    val id: Int,
    @Json(name = "overview")
    val overview: String,
    @Json(name = "poster_path")
    val poster_path: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "video")
    val video: Boolean,

)
