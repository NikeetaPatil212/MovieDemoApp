package com.example.plexigoappdemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Content(
    @Expose
    @SerializedName("contentId")
    val contentId: Int,
    @Expose
    @SerializedName("contentName")
    val contentName: String,
    @Expose
    @SerializedName("externalWebLink")
    val externalWebLink: String,
    @Expose
    @SerializedName("imagePath")
    val imagePath: String,
    @Expose
    @SerializedName("isPlaylist")
    val isPlaylist: Int,
    @Expose
    @SerializedName("isWatchLater")
    val isWatchLater: String,
    @Expose
    @SerializedName("language")
    val language: String,
    @Expose
    @SerializedName("ottWideImagePath")
    val ottWideImagePath: String,
    @Expose
    @SerializedName("synopsis")
    val synopsis: String,
    @Expose
    @SerializedName("tag")
    val tag: String,
    @Expose
    @SerializedName("userLikes")
    val userLikes: Int,
    @Expose
    @SerializedName("wideImagePath")
    val wideImagePath: String,
    @Expose
    @SerializedName("year")
    val year: Int
)