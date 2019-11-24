package com.example.testtask.model.repository.impl

import com.example.testtask.model.db.ArticleDao
import com.example.testtask.model.db.dto.ArticleDbDto
import com.example.testtask.model.entity.ArticleEntity
import com.example.testtask.model.network.NewsApi
import com.example.testtask.model.network.pojo.ArticlePojo
import com.example.testtask.model.repository.ArticlesRepository

class ArticlesRepositoryImpl(
    private val newsApi: NewsApi,
    private val articleDao: ArticleDao
) : ArticlesRepository {

    private fun map(articlePojo: ArticlePojo): ArticleEntity = ArticleEntity(
        articlePojo.title.orEmpty(),
        articlePojo.description.orEmpty(),
        articlePojo.publishedAt.orEmpty(),
        articlePojo.urlToImage.orEmpty(),
        articlePojo.url.orEmpty()
    )

    private fun map(articleEntity: ArticleEntity, order: Int, page: Int, pageSize: Int): ArticleDbDto = ArticleDbDto(
        header = articleEntity.header,
        description = articleEntity.description,
        imageUrl = articleEntity.imageUrl,
        articleUrl =  articleEntity.articleUrl,
        order = order,
        date = articleEntity.date,
        page = page,
        pageSize = pageSize
    )

    private fun map(articleDbDto: ArticleDbDto): ArticleEntity = ArticleEntity(
        articleDbDto.header,
        articleDbDto.description,
        articleDbDto.date,
        articleDbDto.imageUrl,
        articleDbDto.articleUrl
    )
    override fun getArticles(page: Int, pageSize: Int): List<ArticleEntity> {
       val cached = articleDao.select(page, pageSize)
        return  if (cached.isEmpty()){
            val body = newsApi.getArticles(page, pageSize).execute().body()
            val result = body?.articles.orEmpty().map{ map(it) }
            articleDao.insert(result.mapIndexed{ index, articleEntity-> map(articleEntity,index,page,pageSize)})
            result
        } else {
            cached.map { map(it)}
        }
    }

}