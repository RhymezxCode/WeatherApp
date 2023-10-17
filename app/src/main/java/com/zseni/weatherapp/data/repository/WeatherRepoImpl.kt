package com.zseni.weatherapp.data.repository

import com.zseni.weatherapp.data.api.WeatherApi
import com.zseni.weatherapp.data.toWeatherInfo
import com.zseni.weatherapp.domain.weather.WeatherInfo
import com.zseni.weatherapp.domain.repository.WeatherRepository
import com.zseni.weatherapp.domain.util.Resource
import javax.inject.Inject

class WeatherRepoImpl @Inject constructor(
    private val api:WeatherApi
):WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double):Resource<WeatherInfo>{
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e:Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "An Unknown error occurred.")
        }
        // Process and return the data as a list of WeatherInfo objects

    }
}
