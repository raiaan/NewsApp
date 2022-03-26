package com.example.myapplication.ui.login

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
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
import com.example.myapplication.ui.register.RegisterViewModelFactory
import com.example.mydatabaseapp.register.LoginViewModel
import com.example.mydatabaseapp.register.RegisterViewModel


class Login : Fragment() {
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var login: Button
    lateinit var register: TextView

    lateinit var email: String
    lateinit var password:String
    lateinit var loginViewModel: LoginViewModel
    lateinit var loginViewModelFactory: LoginViewModelFactory
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    var emptyData:Boolean=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view=inflater.inflate(R.layout.fragment_login,container,false)
        loginViewModelFactory =
            LoginViewModelFactory((requireActivity().application!! as NewsApplication).repository)
        loginViewModel =
            ViewModelProvider(this, loginViewModelFactory).get(LoginViewModel::class.java)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emailEditText=view.findViewById(R.id.emailLogin)
        register=view.findViewById(R.id.reg)
        login=view.findViewById(R.id.login)
        passwordEditText=view.findViewById(R.id.passwordLogin)
        sharedPreferences=requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)
        editor=sharedPreferences.edit()
       login.setOnClickListener {
           Log.i("login","loginButton")
            login()
        }
        register.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_login2_to_register2)
        }
    }
    private fun getDate(){
        email=emailEditText.text.toString().trim()
        password=passwordEditText.text.toString().trim()
    }
    private fun checkEmptyData():Boolean{
        if(email.isNullOrEmpty()){
            emailEditText.error="please fill the field"
        }
       else if(password.isNullOrEmpty()){
            passwordEditText.error="please fill the field"
        }

        else{
            emptyData=false
        }
        return  emptyData
    }

    private fun validateData():Boolean{

        if(!validateEmail(email)){
            emailEditText.error="invalid email"
         return false
        }
        else if(!validatePassword(password)){
            passwordEditText.error="invalid password"
            return false

        }

        return true
    }
    private fun login() {
        getDate()
        Log.i("login","savedata")
        if (!checkEmptyData()) {
            Log.i("login","empty")
            if (validateData()) {
                Log.i("login","validate")
                var result = loginViewModel.getEmail(email,password)
                if(result !=null){
                    editor.putBoolean("login", true)
                    editor.commit()
                    Log.i("login",""+email)
                     Navigation.findNavController(requireView()).navigate(R.id.action_login2_to_nav_home)

                } else{
                    Log.i("login","fails")
                    Toast.makeText(requireActivity(),"invalid account", Toast.LENGTH_LONG).show()
                }
            }
            else{
                Log.i("login","invaldata")
            }
        }
    }
}