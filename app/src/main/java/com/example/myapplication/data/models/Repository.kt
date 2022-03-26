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
    suspend fun insertUser(user: User) {
        return dao.insertUser(user)
    }

    suspend fun getUseremail(userEmail: String):User?{

        return dao.getUserEmail(userEmail)
    }
}