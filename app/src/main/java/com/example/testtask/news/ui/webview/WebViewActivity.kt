package com.example.testtask.news.ui.webview

import android.os.Bundle
import android.webkit.WebViewClient
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.testtask.R
import com.example.testtask.news.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_web.*

class WebViewActivity :  BaseActivity(),  WebViewView{

    override fun onWebView(url: String) {
        web_view.loadUrl(url)
    }

    @InjectPresenter
    lateinit var webViewPresenter: WebViewPresenter

    @ProvidePresenter
    fun providePresenter(): WebViewPresenter = WebViewPresenter(StringBuilder(intent.getStringExtra("key")).toString())

    override fun onCreate(savedInstanceState: Bundle?){

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        web_view.webViewClient = WebViewClient()

        }

}