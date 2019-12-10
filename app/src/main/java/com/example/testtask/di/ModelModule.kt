package com.example.testtask.di


import com.example.testtask.model.network.NewsApi
import com.example.testtask.model.repository.ArticlesRepository
import com.example.testtask.model.repository.impl.ArticlesRepositoryImpl
import okhttp3.OkHttpClient
import org.koin.dsl.bind
import org.koin.dsl.module

fun prepareNetworkModule() = module {
    single {
        OkHttpClient.Builder().build()
    }
    single {
        NewsApi.getInstance(okHttpClient = get())
    }
}

fun prepareRepositoryModule() = module {
    single {
        ArticlesRepositoryImpl(newsApi = get())
    } bind ArticlesRepository::class
}

