package com.example.myapplication.ui.login

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.models.Repository
import com.example.mydatabaseapp.register.LoginViewModel
import java.lang.IllegalArgumentException

class LoginViewModelFactory(
    private val application: Repository
): ViewModelProvider.Factory {
    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}