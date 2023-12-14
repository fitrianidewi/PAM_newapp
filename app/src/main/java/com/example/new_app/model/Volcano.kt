package com.example.new_app.model

import com.google.gson.annotations.SerializedName

data class Volcano(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("elevation") val elevation: Double,
    // tambahkan atribut lain sesuai dengan respons API
)

