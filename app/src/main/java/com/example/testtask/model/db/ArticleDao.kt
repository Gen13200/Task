package com.example.testtask.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testtask.model.db.dto.ArticleDbDto

@Dao
interface ArticleDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun  insert(articles: List<ArticleDbDto>)

    @Query("SELECT * FROM ArticleDbDto WHERE page=:page AND pageSize=:pageSize ORDER BY `order`")
    fun select(page: Int, pageSize: Int): List<ArticleDbDto>
}