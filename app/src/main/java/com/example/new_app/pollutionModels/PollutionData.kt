package com.example.new_app.pollutionModels

import com.example.new_app.forecastModels.Coord

data class PollutionData(
    val coord: Coord,
    val list: List<Pollution>
)