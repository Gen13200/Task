package com.example.testtask

import android.app.Application
import com.example.testtask.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class NewsApplication : Application(){
    override  fun onCreate(){
        super.onCreate()
        startKoin{
            androidContext(this@NewsApplication)
            loadKoinModules(
                listOf(
                    prepareCommonModule(),
                    prepareNetworkModule(),
                    prepareRepositoryModule(),
                    preparePresenterModule()
                )
            )
        }
    }
}