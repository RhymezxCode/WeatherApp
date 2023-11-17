package com.zseni.weatherapp.presentation.component

import com.zseni.weatherapp.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading:Boolean = false,
    val error:String? = null
)
