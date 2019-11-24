package com.example.testtask.model.network

import com.example.testtask.model.network.pojo.NewsPojo
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    companion object {
        private const val BASE_URL = "https://newsapi.org/"
        private const val DEFAULT_Q = "android"
        private const val DEFAULT_API_KEY = "26eddb253e7840f988aec61f2ece2907"
        private const val DEFAULT_SORT_BY = "publishedAt"
        private const val DEFAULT_FROM = "2019-04-00"

        fun getInstance(okHttpClient: OkHttpClient): NewsApi {
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsApi::class.java)
        }
    }

        @GET("v2/everything")
        fun getArticles(
            @Query("page") page: Int,
            @Query("pageSize") pageSize: Int,
            @Query("q") q: String = DEFAULT_Q,
            @Query("from") from: String = DEFAULT_FROM,
            @Query("sortBy") sortBy: String = DEFAULT_SORT_BY,
            @Query("apiKey") api: String = DEFAULT_API_KEY
        ): Call<NewsPojo>
}
