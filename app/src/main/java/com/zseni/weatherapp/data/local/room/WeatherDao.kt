package com.zseni.weatherapp.data.local.room

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherData(weatherEntity: WeatherEntity)

    @Query("DELETE FROM weather_data")
    fun deleteWeatherData()

    @Query("select * from weather_data")
    suspend fun getWeatherData(): Flow<WeatherEntity>?
}