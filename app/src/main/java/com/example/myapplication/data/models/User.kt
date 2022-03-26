package com.example.myapplication.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val email: String,
    val userName: String,
    val password: String,
    val phoneNumber: String

)
