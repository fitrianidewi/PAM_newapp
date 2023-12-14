package com.example.new_app.model

data class ForecastResponse(
    val data: List<WeatherData>
    // tambahkan properti lainnya yang Anda butuhkan
)

data class WeatherData(
    val temperature: Double,
    val weather: Weather
    // tambahkan properti lainnya yang Anda butuhkan
)

data class Weather(
    val code: Int,
    val description: String
    // tambahkan properti lainnya yang Anda butuhkan
)
