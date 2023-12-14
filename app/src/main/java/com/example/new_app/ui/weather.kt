package com.example.new_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.example.new_app.R
import com.example.new_app.remote.WeatherApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class weather : AppCompatActivity() {
    private lateinit var spinnerLocations: Spinner
    private lateinit var buttonGetWeather: Button
    private lateinit var textViewTemperature: TextView
    private lateinit var textViewDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        spinnerLocations = findViewById(R.id.spinnerLocations)
        buttonGetWeather = findViewById(R.id.buttonGetWeather)
        textViewTemperature = findViewById(R.id.textViewTemperature)
        textViewDescription = findViewById(R.id.textViewDescription)

        buttonGetWeather.setOnClickListener {
            val selectedLocation = spinnerLocations.selectedItem.toString()
            getWeather(selectedLocation)
        }
    }

    private fun getWeather(location: String) {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val response = WeatherApiClient.apiService.getWeather(location, WeatherApiClient.API_KEY)
                val temperature = response.data.firstOrNull()?.temperature
                val description = response.data.firstOrNull()?.weather?.description

                // Set hasil ke dalam TextView
                textViewTemperature.text = "Temperature: $temperature"
                textViewDescription.text = "Description: $description"

            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }
}
