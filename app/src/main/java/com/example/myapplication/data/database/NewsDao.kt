package com.example.myapplication.data.database

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.data.models.User

interface NewsDao {
    @Insert
    suspend fun insert(register: User)


    @Query("SELECT * FROM users WHERE userName LIKE :userName")
    suspend fun getUsername(userName: String): User?
}