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


class RegisterViewModel(val repo:Repository) : ViewModel(){
  fun insert(email:String, userName:String, phoneNumber:String, password:String){
   var user=User(email, userName, password, phoneNumber)
   CoroutineScope(Dispatchers.IO).launch {
     repo.insertUser(user)
   }
 }

}





