package com.example.myapplication.ui.details

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailsViewModel (application: Application) : AndroidViewModel(application) {
    private val _application: Application = application

    private var _navToHome: MutableLiveData<Boolean> = MutableLiveData()
    val navToHome: LiveData<Boolean>
        get() = _navToHome

    fun navToHome() {
        _navToHome.value = true
    }


}