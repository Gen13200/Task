package com.example.testtask.news.ui.articles

import android.content.Intent
import android.os.Bundle
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.testtask.R
import com.example.testtask.model.entity.ArticleEntity
import com.example.testtask.news.ui.base.BaseActivity
import com.example.testtask.news.ui.webview.WebViewViewActivity
import kotlinx.android.synthetic.main.activity_articles.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import java.util.concurrent.Executor

class ArticlesActivity : BaseActivity(), ArticlesView{
    override fun startWebWiev(articleEntity: ArticleEntity) {
        startActivity(Intent(this, WebViewViewActivity::class.java).putExtra("key",articleEntity.articleUrl))
    }

    @InjectPresenter
    lateinit var presenter: ArticlesPresenter

    @ProvidePresenter
    fun providePresenter(): ArticlesPresenter = get()

    private val adapter = ArticleAdapter()

    private val main: Executor by inject(named("main"))
    private val background: Executor by inject(named("background"))

    override fun onCreate(savedInstanceState: Bundle?){
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)
        articles_list_rv.adapter = adapter
        articles_list_rv.layoutManager = LinearLayoutManager(this)

        adapter.listener = object : ArticleAdapter.ArticaleListeneter{
            override fun onClick(articleEntity: ArticleEntity) {
                presenter.onOpenArticle(articleEntity)
            }
        }
    }

    override fun setArticles(f: (page: Int, pageSize: Int) -> List<ArticleEntity>) {
        val config = PagedList.Config.Builder()
            .setPageSize(20)
            .setPrefetchDistance(5)
            .build()
        val dataSource = ArticleDataSource(f, background)
        val pageList = PagedList.Builder(dataSource,config)
            .setFetchExecutor(background)
            .setNotifyExecutor(main)
            .setInitialKey(1)
            .build()
        adapter.submitList(pageList)
    }

}