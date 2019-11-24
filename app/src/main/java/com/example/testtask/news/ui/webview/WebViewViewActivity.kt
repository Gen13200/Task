package com.example.testtask.news.ui.webview

import android.os.Bundle
import android.webkit.WebViewClient
import com.example.testtask.R
import com.example.testtask.news.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_web.*

class WebViewViewActivity :  BaseActivity(),  WebViewView{

    override fun onWebView(url: String) {
        web_view.webViewClient = WebViewClient()
        web_view.loadUrl(url)
    }

    private var webViewPresenter: WebViewPresenter = WebViewPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?){
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        var url = StringBuilder(intent.getStringExtra("key"))
        webViewPresenter.loadWebView(url.toString())
        }

}