package com.example.testtask.news.ui.webview

import com.arellomobile.mvp.InjectViewState
import com.example.testtask.news.ui.base.BasePresenter

@InjectViewState
class WebViewPresenter(private var url:String): BasePresenter<WebViewView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.onWebView(url)
    }

}