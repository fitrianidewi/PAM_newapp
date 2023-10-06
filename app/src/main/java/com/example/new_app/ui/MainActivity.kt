package com.example.new_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.new_app.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun kesignin(view: View) {
        setContentView(R.layout.activity_main)
        //explicit intent
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent( this, login::class.java))
            finish()
        },300 )
    }

    fun kesignup(view: View) {
        setContentView(R.layout.activity_main)
        //explicit intent
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, register::class.java))
            finish()
        }, 300)
    }
}