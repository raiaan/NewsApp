package com.example.myapplication.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.models.Articles
import com.example.myapplication.data.models.User

@Database(entities = [Articles::class,User::class], version =1)
    public abstract class NewsDatabase: RoomDatabase() {
        companion object {
            private var INSTANCE: NewsDatabase? = null
            fun getInstance(application: Application): NewsDatabase {
                return INSTANCE ?: synchronized(this) {
                    val db = Room.databaseBuilder(
                        application.applicationContext,
                        NewsDatabase::class.java, "news"
                    ).build()
                    INSTANCE = db
                    db
                }
            }
        }
    }
