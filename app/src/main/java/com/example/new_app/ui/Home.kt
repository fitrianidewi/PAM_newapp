package com.example.new_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.new_app.R
import com.example.new_app.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        daftarGunung()
        weather()
        cuaca()

    }

    private fun daftarGunung() {
        binding.gunung.setOnClickListener {
            startActivity(Intent(this, daftargunung::class.java))
        }
    }
    private fun weather() {
        binding.ketips.setOnClickListener {
            startActivity(Intent(this, weather::class.java))
            Log.d("WeatherActivity", "Button clicked. Starting Weather activity.")
        }
    }
    private fun cuaca() {
        binding.dont.setOnClickListener {
            startActivity(Intent(this, cuaca::class.java))
            Log.d("WeatherActivity", "Button clicked. Starting Weather activity.")
        }
    }
}