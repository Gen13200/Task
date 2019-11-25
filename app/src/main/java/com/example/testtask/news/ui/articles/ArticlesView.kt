package com.example.testtask.news.ui.articles

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.testtask.model.entity.ArticleEntity
import com.example.testtask.news.ui.base.BaseView

interface  ArticlesView: BaseView{
    @StateStrategyType(SingleStateStrategy::class)
    fun setArticles(f:(page: Int, pageSize: Int) -> List<ArticleEntity>)
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun startWebView(articleEntity: ArticleEntity)
}