package com.zseni.weatherapp.domain.repository

import com.zseni.weatherapp.domain.weather.WeatherInfo
import com.zseni.weatherapp.domain.util.Resource

interface WeatherRepository {
    suspend fun getWeatherData(lat:Double, long: Double): Resource<WeatherInfo>
}