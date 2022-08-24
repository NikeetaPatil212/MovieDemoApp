package com.example.plexigoappdemo.repository

import com.example.plexigoappdemo.model.MovieResponse
import com.example.plexigoappdemo.network.Api

class MoviesRepository(private val apiInterface: Api) {
    fun getMovies(movieResponse: MovieResponse) = apiInterface.getMovies(movieResponse)
}