package com.example.testtask.model.network.pojo

import com.google.gson.annotations.SerializedName

data class NewsPojo(
    @SerializedName("articles")
    val articles: List<ArticlePojo>?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Int?
)