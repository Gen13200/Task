package com.example.testtask.di

import com.example.testtask.news.ui.articles.ArticlesPresenter
import org.koin.dsl.module

fun preparePresenterModule() = module {
    factory {
        ArticlesPresenter(articlesRepository = get())
    }
}