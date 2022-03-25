package com.example.myapplication.data.models

import android.content.Context
import android.util.Log
import com.example.myapplication.data.database.NewsDao
import com.example.myapplication.data.network.RetrofiteService
import retrofit2.Response

class Repository( private val context: Context, val dao: NewsDao) {

    suspend fun getLatestViews(): Response<Json4Kotlin_Base> {
        val retrofitService = RetrofiteService.getInstance()
        return retrofitService.allNews()
    }
    suspend fun insert(user: User) {
        return dao.insert(user)
    }

    suspend fun getUserName(userName: String):User?{

        return dao.getUsername(userName)
    }
}