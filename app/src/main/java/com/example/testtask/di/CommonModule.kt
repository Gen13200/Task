package com.example.testtask.di

import com.example.testtask.news.common.MainExecutor
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import java.util.concurrent.Executor
import java.util.concurrent.Executors

fun prepareCommonModule() = module {
    single (named("background")) {
        Executors.newFixedThreadPool(4)
    } bind Executor::class
    single(named("main")){
        MainExecutor()
    }
}