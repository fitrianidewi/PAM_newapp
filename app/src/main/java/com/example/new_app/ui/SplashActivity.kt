package com.example.new_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.new_app.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //explicit intent
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent( this, MainActivity::class.java))
            finish()
        },3000)
    }
}

