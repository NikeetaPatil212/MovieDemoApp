package com.example.plexigoappdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plexigoappdemo.adapter.MoviesTitleAdapter
import com.example.plexigoappdemo.model.MovieResponse
import com.example.plexigoappdemo.network.Api
import com.example.plexigoappdemo.viewmodel.MoviesViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MoviesViewModel
    private var apiInterface = Api.getInstance()
    private lateinit var movieResponse: MovieResponse
   // var titleAdapter = MoviesTitleAdapter(this)
    lateinit var titleAdapter: MoviesTitleAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieResponse = MovieResponse(59274)

        viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        viewModel.getMoviesList(movieResponse)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        titleAdapter = MoviesTitleAdapter(this)
        recyclerView.adapter = titleAdapter

        viewModel.movieList().observe(this, Observer {


           /* Log.d("Data",it.toString())
            recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
            titleAdapter = MoviesTitleAdapter(this)
            recyclerView.adapter = titleAdapter

            titleAdapter.notifyTitleData(it?.data?.categories!!)*/
            if(it == null){

            }
            else{
                titleAdapter.notifyTitleData(it.data.categories)

            }
        })
    }
}