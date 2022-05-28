package com.bootcamp.imdb.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bootcamp.imdb.R
import com.bootcamp.imdb.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}