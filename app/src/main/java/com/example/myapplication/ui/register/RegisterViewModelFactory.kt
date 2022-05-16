package com.example.myapplication.ui.register


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.models.Repository
import com.example.mydatabaseapp.register.RegisterViewModel
import java.lang.IllegalArgumentException

class RegisterViewModelFactory(
    private val application: Repository
    ): ViewModelProvider.Factory {
    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}