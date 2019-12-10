package com.example.testtask.model.repository.impl



import com.example.testtask.model.entity.ArticleEntity
import com.example.testtask.model.network.NewsApi
import com.example.testtask.model.network.pojo.ArticlePojo
import com.example.testtask.model.repository.ArticlesRepository

class ArticlesRepositoryImpl(
    private val newsApi: NewsApi

) : ArticlesRepository {

    private fun map(articlePojo: ArticlePojo): ArticleEntity = ArticleEntity(
        articlePojo.title.orEmpty(),
        articlePojo.description.orEmpty(),
        articlePojo.publishedAt.orEmpty(),
        articlePojo.urlToImage.orEmpty(),
        articlePojo.url.orEmpty()
    )



    override fun getArticles(page: Int, pageSize: Int): List<ArticleEntity> {

        val body = newsApi.getArticles(page, pageSize).execute().body()
        val result = body?.articles.orEmpty().map{ map(it) }
        return  result

    }

}