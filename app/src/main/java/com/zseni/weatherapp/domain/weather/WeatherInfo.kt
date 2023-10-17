package com.zseni.weatherapp.domain.weather

import com.zseni.weatherapp.data.remote.WeatherData

data class WeatherInfo(
    // This variable maps a number to each day of the week and uses it to provide weather forecasts for the entire
    val weatherDataPerDay:Map<Int, List<WeatherData>>,
    //This gives the weather for each current day/hour
    val currentWeatherData:WeatherData?
)
