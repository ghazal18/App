package com.example.myapplication.domin

import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.database.MovieDatabase
import com.example.myapplication.data.database.MovieDatabase.Companion.DatabaseName
import com.example.myapplication.data.network.ApiService
import com.example.myapplication.model.Movie
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DbModule{

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context):MovieDatabase{
        return Room.databaseBuilder(context,
            MovieDatabase::class.java,DatabaseName)
            .allowMainThreadQueries().build()
    }


    @Singleton
    @Provides
    fun getApiService(): ApiService {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://api.themoviedb.org/3/")
            .build()
        val movieApiService = retrofit.create(ApiService::class.java)
        return movieApiService
    }
}