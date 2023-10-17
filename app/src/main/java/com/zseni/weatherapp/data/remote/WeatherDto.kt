package com.zseni.weatherapp.data.remote

import com.google.gson.annotations.SerializedName

data class WeatherDto(
@field:SerializedName("hourly")
val weatherData: WeatherDataDto
)



