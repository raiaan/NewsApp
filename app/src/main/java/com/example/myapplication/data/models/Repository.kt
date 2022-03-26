package com.example.myapplication.data.models

import androidx.annotation.WorkerThread
import com.example.myapplication.data.database.NewsDao
import com.example.myapplication.data.network.RetrofiteService
import retrofit2.Response

class Repository( private val newsDao: NewsDao) {
    suspend fun getLatestViews(): Response<Json4Kotlin_Base> {
        val retrofitService = RetrofiteService.getInstance()
        return retrofitService.allNews()
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertToFavourite(articles: Articles) {
        articles.isFavourite = true
        newsDao.addArticle(articles)
    }
}