package com.example.plexigoappdemo.network

import com.example.plexigoappdemo.model.MovieData
import com.example.plexigoappdemo.model.MovieResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.concurrent.TimeUnit


interface Api {


    @Headers("X-API-Key: 03a53461dfdf11ea85d10a5cd31394da","content-Type: application/json")
    @POST("content/ChannelWiseContentlisting")

    fun getMovies(@Body uid: MovieResponse): Call<MovieData>

    companion object {
        val BASE_URL = "https://userqaapi.plexigo.com/api/"
        fun getInstance(): Retrofit {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
            client.addInterceptor(logging)
                .connectTimeout(100, TimeUnit.SECONDS) // connect timeout
                .writeTimeout(100, TimeUnit.SECONDS) // write timeout
                .readTimeout(100, TimeUnit.SECONDS)
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}