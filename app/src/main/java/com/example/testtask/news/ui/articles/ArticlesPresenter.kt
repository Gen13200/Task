package com.example.testtask.news.ui.articles

import com.arellomobile.mvp.InjectViewState
import com.example.testtask.model.entity.ArticleEntity
import com.example.testtask.model.repository.ArticlesRepository
import com.example.testtask.news.ui.base.BasePresenter

@InjectViewState
class ArticlesPresenter(private  val articlesRepository: ArticlesRepository): BasePresenter<ArticlesView>(){

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setArticles { page, pageSize ->
            articlesRepository.getArticles(page, pageSize)
        }
    }

    fun onOpenArticle(articleEntity: ArticleEntity){
         viewState.startWebView(articleEntity)
    }
}