package com.example.plexigoappdemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(
    @Expose
    @SerializedName("categories")
    val categories: List<Category>,
    @Expose
    @SerializedName("message")
    val message: Any
)
