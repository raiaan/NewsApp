package com.example.myapplication.ui.home.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.haveNetworkConnection
import com.example.myapplication.data.models.Articles
import com.example.myapplication.data.models.Json4Kotlin_Base
import com.example.myapplication.data.models.Repository
import kotlinx.coroutines.*

class HomeViewModel constructor(private val mainRepository: Repository) : ViewModel(){
    var articlesLiveData= MutableLiveData<List<Articles>?>()
    val errorMessage = MutableLiveData<String>()
    private val loading = MutableLiveData<Boolean>()
    var job: Job? = null
    fun getLatestNews(){
       // if (haveNetworkConnection()){
            job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
                articlesLiveData.postValue(mainRepository.cacheResult())
            }
       // }

    }

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    private fun onError(message: String) {
        errorMessage.postValue(message)
        loading.postValue(false)
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}