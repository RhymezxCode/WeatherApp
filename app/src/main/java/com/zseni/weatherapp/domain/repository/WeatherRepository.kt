package com.zseni.weatherapp.domain.repository


import com.zseni.weatherapp.domain.model.WeatherData
import com.zseni.weatherapp.util.Resource
import kotlinx.coroutines.flow.Flow
interface WeatherRepository {
    suspend fun getWeatherData(
        latitude:Double,
        longitude:Double
    ):Flow<Resource<WeatherData>>
}