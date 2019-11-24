package com.example.testtask.news.ui.base

import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable

abstract  class BasePresenter<T : BaseView> : MvpPresenter<T>(){

    private  val disposables = CompositeDisposable()

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }

}