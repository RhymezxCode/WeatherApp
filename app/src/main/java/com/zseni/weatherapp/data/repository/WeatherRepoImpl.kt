package com.zseni.weatherapp.data.repository

import android.content.Context
import com.zseni.weatherapp.data.api.RemoteDataSource
import com.zseni.weatherapp.data.api.WeatherApiService
import com.zseni.weatherapp.data.local.room.AppDatabase
import com.zseni.weatherapp.data.local.room.LocalDataSource
import com.zseni.weatherapp.domain.model.WeatherData
import com.zseni.weatherapp.domain.repository.WeatherRepository
import com.zseni.weatherapp.util.NetworkUtils
import com.zseni.weatherapp.util.Resource
import com.zseni.weatherapp.util.networkBoundResource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import javax.inject.Inject

class WeatherRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,

):WeatherRepository{

    override suspend fun getWeatherData(
        latitude: Double,
        longitude: Double
    ): Flow<Resource<WeatherData>>  = networkBoundResource(
        query = {
          localDataSource.getWeatherData()?: flowOf(null)
        },
        fetch = {
            delay(2000)
            remoteDataSource.getWeatherData(latitude, longitude).first()
        },
        saveFetchResult = { weatherData ->
            weatherData?.let {
                localDataSource.insertWeatherData(it)
                localDataSource.deleteWeatherData()
            }
        },
        shouldFetch = { weatherData ->
            weatherData.isEmpty()
        }


    )

}
