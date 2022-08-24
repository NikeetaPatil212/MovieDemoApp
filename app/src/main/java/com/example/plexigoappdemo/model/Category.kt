package com.example.plexigoappdemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Category(
    @Expose
    @SerializedName("channelID")
    val channelID: Int,
    @Expose
    @SerializedName("channelName")
    val channelName: String,
    @Expose
    @SerializedName("content")
    val content: List<Content>,
    @Expose
    @SerializedName("pageCount")
    val pageCount: Int
)
