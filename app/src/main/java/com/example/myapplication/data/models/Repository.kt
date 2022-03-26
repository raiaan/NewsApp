package com.example.myapplication.data.models

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.database.NewsDao
import com.example.myapplication.data.haveNetworkConnection
import com.example.myapplication.data.network.RetrofiteService
import kotlinx.coroutines.*
import retrofit2.Response

class Repository( private val newsDao: NewsDao) {
    var mutableLiveData= MutableLiveData<Json4Kotlin_Base>()
    suspend fun getLatestViews(): Response<Json4Kotlin_Base> {
        val retrofitService = RetrofiteService.getInstance()
        return retrofitService.allNews()
    }
    suspend fun insertUser(user: User) {
        return newsDao.insertUser(user)
    }

    suspend fun validateUser(userEmail: String,password:String):User?{

        return newsDao.validateUser(userEmail,password)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertToFavourite(articles: Articles) {
        articles.isFavourite = true
        newsDao.addArticle(articles)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertCachedItem(articles: Articles){
        newsDao.addArticle(articles)
    }
    suspend fun cacheResult( ):List<Articles>?{
        val response = getLatestViews()
        if (response.isSuccessful) {
            response.body()?.articles?.forEach {
                insertCachedItem(it)
            }
        } else {
            Log.v("Error","${response.errorBody()?.string()}")
        }
        return  newsDao.getCachedArticles()
    }
}