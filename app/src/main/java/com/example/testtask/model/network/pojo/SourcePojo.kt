package com.example.testtask.model.network.pojo

import com.google.gson.annotations.SerializedName

data class SourcePojo(
    @SerializedName("id")
    val id: Any?,
    @SerializedName("name")
    val name: String?
)