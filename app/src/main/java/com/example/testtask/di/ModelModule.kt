package com.example.testtask.di

import androidx.room.Room
import com.example.testtask.model.db.NewsRoomDatabase
import com.example.testtask.model.network.NewsApi
import com.example.testtask.model.repository.ArticlesRepository
import com.example.testtask.model.repository.impl.ArticlesRepositoryImpl
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
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
        ArticlesRepositoryImpl(newsApi = get(), articleDao = get())
    } bind ArticlesRepository::class
}

fun prepareDbModule() = module {
    single {
        Room.databaseBuilder(androidApplication(), NewsRoomDatabase::class.java, "news.db").build()
    } bind NewsRoomDatabase::class
    single {
        get<NewsRoomDatabase>().getArticleDao()
    }
}