package com.example.testtask.model.db.dto

import android.content.ClipDescription
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticleDbDto(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    val header: String,
    val description: String,
    val date: String,
    val imageUrl: String,
    val articleUrl: String,
    val order: Int,
    val page: Int,
    val pageSize: Int){
}
