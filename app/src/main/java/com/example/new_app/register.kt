package com.example.new_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun kesignin(view: View) {
        setContentView(R.layout.activity_main)
        //explicit intent
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent( this, login::class.java))
            finish()
        },300 )
    }
}