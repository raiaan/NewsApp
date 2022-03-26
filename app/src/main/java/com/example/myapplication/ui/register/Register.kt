package com.example.myapplication.ui.register

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.myapplication.*
import com.example.mydatabaseapp.register.RegisterViewModel


class Register : Fragment() {
lateinit var userNameEditText: EditText
lateinit var emailEditText: EditText
lateinit var passwordEditText: EditText
lateinit var phoneNumberEditText: EditText
lateinit var register:Button
lateinit var login:TextView


lateinit var userName:String
lateinit var email: String
lateinit var phoneNumber:String
lateinit var password:String
lateinit var registerViewModel: RegisterViewModel
lateinit var registerViewModelFactory: RegisterViewModelFactory
lateinit var sharedPreferences: SharedPreferences
lateinit var editor: SharedPreferences.Editor
var emptyData:Boolean=true
    var validateData:Boolean=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view=inflater.inflate(R.layout.fragment_register,container,false)
        registerViewModelFactory =
            RegisterViewModelFactory((requireActivity().application!! as NewsApplication).repository)
        registerViewModel =
            ViewModelProvider(this, registerViewModelFactory).get(RegisterViewModel::class.java)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userNameEditText=view.findViewById(R.id.userNameEdite)
        emailEditText=view.findViewById(R.id.emailEdite)
        phoneNumberEditText=view.findViewById(R.id.emailEdite)
        register=view.findViewById(R.id.register)
        login=view.findViewById(R.id.loginreg)
        passwordEditText=view.findViewById(R.id.passwordEdite)
        sharedPreferences=requireActivity().getSharedPreferences("register",Context.MODE_PRIVATE)
        editor=sharedPreferences.edit()
      register.setOnClickListener {
      register()
      }
    }
    private fun saveDate(){
        userName=userNameEditText.text.toString().trim()
        email=emailEditText.text.toString().trim()
        phoneNumber=phoneNumberEditText.text.toString().trim()
        password=passwordEditText.text.toString().trim()
    }
    private fun checkEmptyData():Boolean{
        if(userName.isNullOrEmpty()){
           userNameEditText.error="please fill the field"
        }
        else if(password.isNullOrEmpty()){
            passwordEditText.error="please fill the field"
        }
        else if(email.isNullOrEmpty()){
            emailEditText.error="please fill the field"
        }
        else if(phoneNumber.isNullOrEmpty()){
            phoneNumberEditText.error="please fill the field"
        }
        else{
            emptyData=false
        }
        return  emptyData
    }

    private fun validateData():Boolean{
        if(!validateEmail(email)){
            emailEditText.error="invalid email"
        }
       else if(!validatePassword(password)){
            passwordEditText.error="invalid password"
        }
        else if(!validatePhone(phoneNumber)){
            phoneNumberEditText.error="invalid phoneNumber"
        }
        else {
            validateData=false
        }
        return validateData
    }
    private  fun register() {
        saveDate()
        if (!checkEmptyData()) {
            if (validateData()) {
                var result = registerViewModel.insert(email,userName,phoneNumber,password)
                if(result != null){
                    editor.putBoolean("register", true)
                    editor.commit()
                 //   Navigation.findNavController(requireView()).navigate(R.id.action_from_registration_to_home)
                } else{

                    Toast.makeText(requireActivity(),"you already have an account", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}

