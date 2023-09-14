package com.example.new_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Parcel
import android.os.Parcelable
import android.os.PersistableBundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //explicit intent
                binding.button1.setOnClickListener{ it:View!
            startActivity(Intent( this, login::class.java))
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent( this, MainActivity::class.java))
            finish()
        },3000)
    }
}

