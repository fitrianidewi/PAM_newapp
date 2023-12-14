package com.example.new_app.remote

import com.example.new_app.model.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("weather/forecast")
    suspend fun getWeather(
        @Query("location") location: String,
        @Query("apikey") apiKey: String
    ): ForecastResponse
}