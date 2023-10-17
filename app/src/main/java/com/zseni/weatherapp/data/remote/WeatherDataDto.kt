package com.zseni.weatherapp.data.remote

import com.google.gson.annotations.SerializedName

data class WeatherDataDto(
    @field:SerializedName( "time")
    val time: List<String>,
    @field:SerializedName("temperature_2m")
    val temperatures: List<Double>,
    @field:SerializedName("weathercode")
    val weatherCodes: List<Int>,
    @field:SerializedName("pressure_msl")
    val pressures: List<Double>,
    @field:SerializedName("relativehumidity_2m")
    val humidities: List<Double>,
    @field:SerializedName( "windspeed_10m")
    val windSpeeds: List<Double>,

)


//val time: List<String>,
//@field:SerializedName(name = "pressure_msl")
//val pressures: List<Double>,
//@field:Json(name = "relativehumidity_2m")
//val humidity: List<Double>,
//@field:Json(name = "temperature_2m")
//val temperature: List<Double>,
//@field:Json(name = "weathercode")
//val weatherCodes:List<Int>,
//@field:Json(name = "windspeed_10m")
//val windSpeeds: List<Double>,
