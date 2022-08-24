package com.example.plexigoappdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.plexigoappdemo.R
import com.example.plexigoappdemo.model.Category
import com.example.plexigoappdemo.model.Content
import kotlinx.android.synthetic.main.item_image.view.*
import kotlinx.android.synthetic.main.item_text.view.*

class MoviesTitleAdapter(val context: Context): RecyclerView.Adapter<MoviesTitleAdapter.MoviesTitleViewHolder>() {

    var moviesTitle: List<Category> = listOf()

    inner class MoviesTitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val recyclerView = itemView.findViewById<RecyclerView>(R.id.movieRecyclerView)
        val adapter = MovieImageAdapter(context)

        init {
            recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            recyclerView.adapter = adapter
        }

        fun binds(category: List<Content>){
            adapter.notifyImageData(category)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesTitleViewHolder {
        return MoviesTitleViewHolder(
            LayoutInflater.from(parent.context!!).inflate(R.layout.item_text, parent, false)
        )
    }
    override fun onBindViewHolder(holder: MoviesTitleViewHolder, position: Int) {
        val movies = moviesTitle[position]

        holder.itemView.apply {
            textViewTitle.text = movies?.channelName
        }

        holder.binds(movies.content)
    }

    override fun getItemCount(): Int {
        return moviesTitle.size
    }

    fun notifyTitleData(movies: List<Category>) {
        this.moviesTitle = movies
        notifyDataSetChanged()
    }
}