package com.example.testtask.news.ui.webview

class WebViewPresenter(webViewView: WebViewView){

    private var webViewView: WebViewView = webViewView

    fun loadWebView(url: String){
        webViewView.onWebView(url)
    }
}