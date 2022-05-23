package com.example.myapplication.model

data class UpComingMovieList(
    val dates: Dates,
    val page: Int,
    val results: List< UpComingResult>,
    val total_pages: Int,
    val total_results: Int
)