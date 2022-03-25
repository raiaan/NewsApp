package com.example.myapplication.data.models

import android.content.Context
import com.example.myapplication.data.network.RetrofiteService
import retrofit2.Response

class Repository( private val context: Context) {
    suspend fun getLatestViews(): Response<Json4Kotlin_Base> {
        val retrofitService = RetrofiteService.getInstance()
        return retrofitService.allNews()
    }
}