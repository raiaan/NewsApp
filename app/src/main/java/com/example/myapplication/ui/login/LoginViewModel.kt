package com.example.myapplication.ui.login

import android.app.Application
import android.database.Observable
import android.util.Log

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.NewsApplication
import com.example.myapplication.data.models.Repository

class LoginViewModel( application: Application) :
    AndroidViewModel(application) {

var repo:Repository
    init {
        repo=(application as NewsApplication).repository
    }




}