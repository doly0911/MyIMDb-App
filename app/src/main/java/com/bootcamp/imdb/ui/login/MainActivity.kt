package com.bootcamp.imdb.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bootcamp.imdb.data.remote.dataSources.auth.AuthRemoteDataSource
import com.bootcamp.imdb.databinding.ActivityMainBinding
import com.bootcamp.imdb.domain.remote.auth.AuthRepositoryImpl
import com.bootcamp.imdb.ui.HomeActivity
import com.bootcamp.imdb.ui.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val firebaseAuth by lazy { FirebaseAuth.getInstance() }
    private val viewModel by viewModels<LoginViewModel> {
        LoginViewModel.LoginViewModelFactory(AuthRepositoryImpl(AuthRemoteDataSource()))
    }
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        goToSignUpPage()
        isUserLoggedIn()
        doLogin()

    }

    //verifica si el usuario ya esta logueado para redirigirlo directamente al home
    private fun isUserLoggedIn() {
        firebaseAuth.currentUser?.let {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    //Realiza la autenticacion del usuario
    private fun doLogin() {
        binding.btnLogin.setOnClickListener {
            val email = binding.editTxtEmail.text.toString().trim()
            val password = binding.editTxtPassword.text.toString().trim()
            validateCredentials(email, password)
            signIn(email, password)
        }
    }

    private fun validateCredentials(email: String, password: String){
        if (email.isEmpty()){
            binding.editTxtEmail.error = "El email esta vacío"
            return
        }

        if (password.isEmpty()){
            binding.editTxtEmail.error = "La contraseña esta vacía"
            return
        }
    }

    private fun signIn(email:String, password: String){
        viewModel.signIn(email, password)
        viewModel.authResponse.observe(this, Observer {
            Log.d("Service response", it.toString())
            startActivity(Intent(this, HomeActivity::class.java))
        })
    }

    private fun goToSignUpPage(){
        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}