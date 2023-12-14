package com.example.new_app.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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
            startActivity(Intent(this, CurrentWeather::class.java))
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