package com.bootcamp.imdb.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bootcamp.imdb.data.remote.dataSources.auth.LoginDataSource
import com.bootcamp.imdb.databinding.ActivityMainBinding
import com.bootcamp.imdb.domain.auth.LoginRepositoryImpl
import com.bootcamp.imdb.ui.HomeActivity
import com.bootcamp.imdb.ui.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val firebaseAuth by lazy { FirebaseAuth.getInstance() }
    private val viewModel by viewModels<LoginViewModel> {
        LoginViewModel.LoginViewModelFactory(LoginRepositoryImpl(LoginDataSource()))
    }
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

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
        viewModel.authResponse.observe(this, Observer {
            viewModel.signIn(email, password)
            startActivity(Intent(this, HomeActivity::class.java))
        })
    }
}