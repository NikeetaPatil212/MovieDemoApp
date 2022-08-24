package com.example.plexigoappdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.plexigoappdemo.R
import com.example.plexigoappdemo.model.Category
import com.example.plexigoappdemo.model.Content
import kotlinx.android.synthetic.main.item_image.view.*

class MovieImageAdapter(context: Context?): RecyclerView.Adapter<MovieImageAdapter.ViewHolder>() {

    var moviesImage: List<Content> = listOf()
    private val context: Context? = context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_image,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movies = moviesImage[position]

        holder.itemView.apply {
            Glide.with(this).load(movies.imagePath).into(imgMovie)
            tvLanguage.text = movies.language
            tvMovieTitle.text = movies.contentName
        }
    }

    override fun getItemCount(): Int {
        return moviesImage.size
    }

    fun notifyImageData(movies: List<Content>){
        this.moviesImage = movies
        notifyDataSetChanged()
    }
}