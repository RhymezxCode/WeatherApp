package com.zseni.weatherapp.data.api

import com.zseni.weatherapp.data.remote.WeatherDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
   @GET("v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
   suspend fun getWeatherData(
       @Query("latitude") lat:Double,
       @Query("longitude") long:Double
   ): WeatherDto
}
//?latitude=52.52&longitude=13.41&hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl