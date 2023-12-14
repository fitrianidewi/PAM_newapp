package com.example.new_app.remote

import com.example.new_app.model.Volcano
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("getVolcanoes")
    fun getVolcanoes(): Call<List<Volcano>>

}
