package com.bootcamp.imdb.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bootcamp.imdb.MainActivity

class SplashActivity : AppCompatActivity() {
 //   private val time: Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     /*  setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        //Splash screen
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, time ) */
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}