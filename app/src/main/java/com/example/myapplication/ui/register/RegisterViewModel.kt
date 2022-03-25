package com.example.mydatabaseapp.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myapplication.NewsApplication
import com.example.myapplication.data.models.Repository


class RegisterViewModel(application: Application) :
 AndroidViewModel(application) {
 var repo: Repository
 init {
  repo=(application as NewsApplication).repository
 }



}





