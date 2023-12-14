package com.example.new_app.forecastModels

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)