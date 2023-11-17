package com.zseni.weatherapp.data.api

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName

//This is equivalent to weatherDto

data class WeatherResponse(
    val lat: Double,
    val lon: Double,
    val timezone: String,
    @SerializedName("timezone_offset")
    val timezoneOffset: Int,
    val current: CurrentWeather,
    val daily: List<DailyWeather>,
    val hourly: List<HourlyWeather>
)
//these are the data contained in the data classes

data class CurrentWeather(
    val dt: Long,
    val temp: Double,
    val sunrise: Long,
    val sunset: Long,
    @SerializedName("feels_like")
    val feelsLike: Double,
    val pressure: Int,
    val humidity: Int,
    val dewPoint: Double,
    val uvi: Double,
    val clouds: Int,
    val visibility: Int,
    @SerializedName("wind_speed")
    val windSpeed: Double,
    @SerializedName("wind_deg")
    val windDeg: Int,
    @SerializedName("wind_gust")
    val windGust: Double,
    val weather: List<Weather>,

)


data class DailyWeather(
    val dt: Long,
    val temp: Temp,
    val sunrise: Long,
    val sunset: Long,
    val moonrise: Long,
    val moonSet: Long,
    val moonPhase: Double,
    val summary: String,
    @SerializedName("feels_like")
    val feelsLike: FeelsLike,
    val pressure: Int,
    val humidity: Int,
    @SerializedName("dew_point")
    val dewPoint: Double,
    @SerializedName("wind_speed")
    val windSpeed: Double,
    @SerializedName("wind_deg")
    val windDeg: Int,
    @SerializedName("wind_gust")
    val windGust: Double,
    val clouds: Int,
    val pop: Double,
    val uvi: Double,
    val weather: List<Weather>,
)


data class HourlyWeather(
    val dt: Long,
    val temp: Temp,
    val weather: List<Weather>,
    val pressure: Int,
    val humidity: Int,
    val dewPoint: Double,
    @SerializedName("feels_like")
    val feelsLike: FeelsLike,
    val uvi: Double,
    val clouds: Int,
    val visibility: Int,
    @SerializedName("wind_speed")
    val windSpeed: Double,
    @SerialName("wind_deg")
    val windDeg: Int,
    @SerialName("wind_gust")
    val windGust: Double,
)


data class Temp(
    val day: Double,
    val min: Double,
    val max: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
)


data class FeelsLike(
    val day: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
)

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

