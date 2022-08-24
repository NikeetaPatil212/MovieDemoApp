package com.example.plexigoappdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.plexigoappdemo.model.MovieData
import com.example.plexigoappdemo.model.MovieResponse
import com.example.plexigoappdemo.network.Api
import com.example.plexigoappdemo.repository.MoviesRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel : ViewModel() {

    val movieList : MutableLiveData<MovieData?> = MutableLiveData()
    val errorMessage = MutableLiveData<String>()

    fun movieList() : MutableLiveData<MovieData?>{
        return movieList
    }

    fun getMoviesList(movieResponse: MovieResponse) {
        val retroservice = Api.getInstance().create(Api::class.java)
        val response = retroservice.getMovies(movieResponse)
        response.enqueue(object: Callback<MovieData?>{
            override fun onResponse(call: Call<MovieData?>, response: Response<MovieData?>) {
                if (response.isSuccessful) {
                    movieList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<MovieData?>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}