package com.bootcamp.imdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bootcamp.imdb.activities.HomeActivity
import com.bootcamp.imdb.register.RegisterActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.btn_login)
        btnRegister = findViewById(R.id.btn_register)

        btnLogin.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}