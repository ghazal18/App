package com.example.myapplication.model

data class UpcomingMovieList(
    val dates: Dates,
    val page: Int,
    val results: List< UpComingResult>,
    val total_pages: Int,
    val total_results: Int
)