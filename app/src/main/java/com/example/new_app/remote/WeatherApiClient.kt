package com.example.new_app.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherApiClient {
    private const val BASE_URL = "https://api.tomorrow.io/v4/"
    const val API_KEY = "Un4XKNqqgwphiXC72KaEosbT05TcOywC"

    private fun getApiKey(): String {
        return API_KEY
    }

    val apiService: WeatherApiService by lazy {
        val okHttpClient = OkHttpClient.Builder().build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        retrofit.create(WeatherApiService::class.java)
    }
}
