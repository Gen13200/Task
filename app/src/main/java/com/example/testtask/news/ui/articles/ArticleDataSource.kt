package com.example.testtask.news.ui.articles

import androidx.paging.PageKeyedDataSource
import com.example.testtask.model.entity.ArticleEntity
import java.util.concurrent.Executor

class ArticleDataSource(private val f: (page: Int, pageSize: Int) -> List<ArticleEntity>,
                        private val executor: Executor): PageKeyedDataSource<Int, ArticleEntity>(){
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ArticleEntity>
    ) {
        executor.execute{
            callback.onResult(f(1,params.requestedLoadSize), null, 2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ArticleEntity>) {
        val page = params.key + 1
        callback.onResult(f(params.key, params.requestedLoadSize), page)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ArticleEntity>) {
        val page = if (params.key -1 < 1) {
                null
            } else {
            params.key - 1
        }
        callback.onResult(f(params.key, params.requestedLoadSize), page)
    }

}