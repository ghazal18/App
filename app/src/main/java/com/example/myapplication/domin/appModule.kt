package com.example.myapplication.domin

import com.example.myapplication.data.MovieLocalDataSource
import com.example.myapplication.data.MovieRemoteDataSource
import com.example.myapplication.data.MovieRepository
import com.example.myapplication.data.database.MovieDatabase
import com.example.myapplication.data.network.ApiService
import com.example.myapplication.ui.movieDetail.DetailViewModel
import com.example.myapplication.ui.movieList.MovieListViewModel
import com.example.myapplication.ui.search_result.SearchResultViewModel
import com.example.myapplication.ui.upComingMovie.UpComingMovieViewModel
import com.example.myapplication.ui.video_webview.ShowVideoViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import kotlin.math.sin

val appModule = module {
    single { MovieRepository(get(),get())}
    single { MovieRemoteDataSource(get())}
    single {MovieLocalDataSource(get(),get(),get(),)}
    single {
        val retrofit = get() as Retrofit
        val apiService = retrofit.create(ApiService::class.java)
        apiService
    }
    single {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
        val client = OkHttpClient.Builder().addInterceptor(logger).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()
        retrofit
    }
    viewModel { DetailViewModel(get())}
    viewModel { MovieListViewModel(get()) }
    viewModel { UpComingMovieViewModel(get()) }
    viewModel { SearchResultViewModel(get()) }
    viewModel { ShowVideoViewModel(get()) }

    single { MovieDatabase.getDatabase(androidContext()) }
    single { get<MovieDatabase>().MovieDao() }
    single { get<MovieDatabase>().MovieDetailDao() }
    single { get<MovieDatabase>().UpComingResultDao() }
}