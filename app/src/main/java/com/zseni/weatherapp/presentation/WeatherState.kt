package com.zseni.weatherapp.presentation

import com.zseni.weatherapp.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading:Boolean = false,
    val error:String? = null
)
