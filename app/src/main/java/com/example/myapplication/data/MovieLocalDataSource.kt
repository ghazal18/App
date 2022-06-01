package com.example.myapplication.data

import com.example.myapplication.data.database.DaoOfMovie
import com.example.myapplication.data.database.DaoOfMovieDetail
import com.example.myapplication.data.database.DaoOfUpComingResult

class MovieLocalDataSource(val movieDao: DaoOfMovie,val movieDetailDao: DaoOfMovieDetail, val upComingResultDao: DaoOfUpComingResult ) {


}