package com.example.myapplication.data.database

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.data.models.User

interface NewsDao {
    @Insert
    suspend fun insertUser(register: User)


    @Query("SELECT * FROM users WHERE email LIKE :email")
    suspend fun getUserEmail(email: String): User?
}