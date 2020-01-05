package com.tengtonghann.android.kotlin_mvvm_dagger.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Movie(

    @Expose
    @SerializedName("id")
    val id: Int,

    @Expose
    @SerializedName("image")
    val image: String,

    @Expose
    @SerializedName("is_new")
    val is_new: Int,

    @Expose
    @SerializedName("language")
    val language: String,

    @Expose
    @SerializedName("like_percent")
    val like_percent: Int,

    @Expose
    @SerializedName("rating")
    val rating: String,

    @Expose
    @SerializedName("title")
    val title: String,

    @Expose
    @SerializedName("type")
    val type: String,

    @Expose
    @SerializedName("vote_count")
    val vote_count: Int
)