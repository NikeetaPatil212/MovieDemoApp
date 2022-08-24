package com.example.plexigoappdemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @Expose
    @SerializedName("UserId")
    var UserId: Int
)
