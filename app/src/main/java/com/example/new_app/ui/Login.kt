package com.example.new_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.new_app.R

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun kesignup(view: View) {
        setContentView(R.layout.activity_main)
        //explicit intent
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, register::class.java))
            finish()
        }, 300)
    }
    fun kehome(view: View) {
        setContentView(R.layout.activity_main)
        //explicit intent
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, home::class.java))
            finish()
        }, 30)
    }
}