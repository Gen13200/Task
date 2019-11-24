package com.example.testtask.news.ui.articles

import androidx.recyclerview.widget.DiffUtil
import com.example.testtask.model.entity.ArticleEntity

class ArticleItemCallback: DiffUtil.ItemCallback<ArticleEntity>(){

    override fun areItemsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
        return  oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
        return true
    }

}