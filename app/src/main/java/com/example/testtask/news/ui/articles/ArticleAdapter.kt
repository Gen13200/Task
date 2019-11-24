package com.example.testtask.news.ui.articles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testtask.R
import com.example.testtask.model.entity.ArticleEntity
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleAdapter : PagedListAdapter<ArticleEntity, ArticleAdapter.ArticleViewHolder>(ArticleItemCallback()){

    var listener: ArticaleListeneter? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent,false))
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(getItem(position))

    }

    inner class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view){

        fun bind(article: ArticleEntity?) = itemView.apply {
            if (article != null){
                title.text = article.header
                description.text = article.description
                date.text = article.date
                Glide.with(this)
                    .load(article.imageUrl)
                    .into(image)

                itemView.setOnClickListener {
                    listener?.onClick(article) }
            }

        }
    }

    interface ArticaleListeneter{
        fun onClick(articleEntity: ArticleEntity)
    }
}