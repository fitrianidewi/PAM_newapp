package com.example.new_app.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://volcanoes.usgs.gov/hans2/apiv2/volcanoApi/allWithNotice/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(getOkHttpClient())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)

    private fun getOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        // Konfigurasi lainnya jika diperlukan
        return builder.build()
    }
}
