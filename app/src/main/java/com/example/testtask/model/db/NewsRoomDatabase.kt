package com.example.testtask.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testtask.model.db.dto.ArticleDbDto

@Database(entities = [ArticleDbDto::class], version = 1)
abstract class NewsRoomDatabase : RoomDatabase(){
    abstract  fun getArticleDao(): ArticleDao
}