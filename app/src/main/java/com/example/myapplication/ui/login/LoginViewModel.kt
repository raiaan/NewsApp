package com.example.mydatabaseapp.register

import android.app.Application
import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.*
import com.example.myapplication.NewsApplication
import com.example.myapplication.data.models.Repository
import com.example.myapplication.data.models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class LoginViewModel(val repo:Repository) : ViewModel(){
     fun getEmail(email:String):Boolean{
        var result:Boolean=false
        CoroutineScope(Dispatchers.IO).launch {

           if (repo.getUseremail(email)!=null) {
               result=true
           }

        }
        return result
    }

}





