package com.zseni.weatherapp.data.local.room

import com.zseni.weatherapp.data.local.mappers.WeatherEntityMapper
import com.zseni.weatherapp.domain.model.WeatherData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val weatherDao: WeatherDao,
) {
    suspend fun insertWeatherData(weatherData: WeatherData) {
       val weatherEntity = WeatherEntityMapper.mapWeatherDataToWeatherEntity(weatherData)
        weatherDao.insertWeatherData(weatherEntity)

    }
    suspend fun getWeatherData(): Flow<WeatherData>? {
        return weatherDao.getWeatherData()?.map {weatherEntity ->
            WeatherEntityMapper.mapWeatherEntityToWeatherData(weatherEntity)
        }
    }
    suspend fun deleteWeatherData(){
        weatherDao.deleteWeatherData()
    }
}