package com.example.myapplication

import com.example.myapplication.data.database.NewsDao
import com.example.myapplication.data.models.User

class Repository(private val dao: NewsDao) {
    suspend fun insert(user: User) {
        return dao.insert(user)
    }
    suspend fun getUserName(userName: String):User?{
        return dao.getUser(userName)
    }
}