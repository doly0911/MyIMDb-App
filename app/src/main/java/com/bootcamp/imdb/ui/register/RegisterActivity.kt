package com.bootcamp.imdb.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bootcamp.imdb.data.remote.dataSources.auth.AuthRemoteDataSource
import com.bootcamp.imdb.databinding.ActivityRegisterBinding
import com.bootcamp.imdb.domain.remote.auth.AuthRepositoryImpl
import com.bootcamp.imdb.ui.HomeActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel by viewModels<RegisterViewModel>{
        RegisterViewModel.RegisterViewModelFactory(AuthRepositoryImpl(AuthRemoteDataSource()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        signUp()
    }

    private fun signUp(){
        binding.btnSignUp.setOnClickListener {
            val username = binding.inputName.text.toString().trim()
            val email = binding.inputEmail.text.toString().trim()
            val password = binding.inputPassword.text.toString().trim()
            validateCredentials(username, email, password)
            createUser(username, email, password)
        }
    }

    private fun createUser(username: String, email: String, password: String) {
        viewModel.createUser(username, email, password)
        viewModel.registerResponse.observe(this, Observer {
            Log.d("Register response", it.toString())
            startActivity(Intent(this, HomeActivity::class.java))
        })
    }

    private fun validateCredentials(user: String, email: String, password: String){
        if (user.isEmpty()){
            binding.inputName.error = "El usuario esta vacío"
            return
        }

        if (email.isEmpty()){
            binding.inputEmail.error = "El email esta vacío"
            return
        }

        if (password.isEmpty()){
            binding.inputPassword.error = "La contraseña esta vacía"
            return
        }
    }
}