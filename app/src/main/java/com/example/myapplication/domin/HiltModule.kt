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


@Module
@InstallIn(SingletonComponent::class)
object DbModule{

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context):MovieDatabase{
        return Room.databaseBuilder(context.applicationContext,
            MovieDatabase::class.java,DatabaseName)
            .allowMainThreadQueries().build()
    }

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
        val client = OkHttpClient.Builder().addInterceptor(logger).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://6086fa75a3b9c200173b758e.mockapi.io/api/v1/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()
        val movieApiService = retrofit.create(ApiService::class.java)

        return movieApiService
    }
}