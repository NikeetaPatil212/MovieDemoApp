package com.example.plexigoappdemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieData(
    @Expose
    @SerializedName("data")
    val data : Data,
    @Expose
    @SerializedName("status")
    val status: String,
    @Expose
    @SerializedName("statusCode")
    val statusCode: String
)