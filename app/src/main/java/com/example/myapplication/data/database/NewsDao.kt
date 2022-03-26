package com.example.myapplication.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.models.Articles
import com.example.myapplication.data.models.User
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Insert
    suspend fun insertUser(register: User)


    @Query("SELECT * FROM users WHERE email LIKE :email AND password LIKE:password")
    suspend fun validateUser(email: String,password:String): User?
    @Query("SELECT * FROM articles ORDER BY publishedAt ASC")
    fun getCachedArticles(): List<Articles>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addArticle(article: Articles)

}