package com.example.testtask.model.repository

import com.example.testtask.model.entity.ArticleEntity

interface ArticlesRepository{
    fun getArticles(page: Int, pageSize: Int) : List<ArticleEntity>
}