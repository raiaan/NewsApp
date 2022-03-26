package com.example.myapplication

import android.app.Application
import com.example.myapplication.data.database.NewsDatabase
import com.example.myapplication.data.models.Repository

class NewsApplication: Application() {
    val database by lazy { NewsDatabase.getInstance(this) }
    val repository by lazy { Repository( database.newsDao()) }
}