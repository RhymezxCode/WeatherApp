package com.zseni.weatherapp.data.local.mappers

import com.zseni.weatherapp.data.api.CurrentWeather
import com.zseni.weatherapp.data.api.DailyWeather
import com.zseni.weatherapp.data.api.WeatherResponse
import com.zseni.weatherapp.domain.model.DailyForecast
import com.zseni.weatherapp.domain.model.Weather
import com.zseni.weatherapp.domain.model.WeatherData
import com.zseni.weatherapp.util.DrawableUtils
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone


object WeatherResponseMapper {
    fun mapWeatherResponseToWeatherData(response: WeatherResponse): WeatherData {
       val background = DrawableUtils.getBackgroundBasedOnTime(response.current.dt,response.timezone)
       val currentWeather = mapCurrentWeather(response.current, response.timezone)
        val dailyWeatherList = mapDailyWeather(response.daily, response.timezone)
        return WeatherData(background, currentWeather,dailyWeatherList)
    }

    private fun mapCurrentWeather(current: CurrentWeather, timeZone:String): Weather {
        val weatherDescription = current.weather.firstOrNull()?.description.orEmpty()
        return Weather(
            sunrise = current.sunrise.toHMM(timeZone),
            sunset = current.sunset.toEEE(timeZone),
            temperature = current.temp,
            feelsLike = current.feelsLike,
            pressure = current.pressure,
            humidity = current.humidity,
            visibility = current.visibility,
            uvi = current.uvi,
            windSpeed = current.windSpeed,
            windDegree = current.windDeg,
            weather = weatherDescription
        )
    }

    /**
    this function allows you to convert a Unix timestamp
     to a time string in a specific format ("HH:mm") or (EEE)
    and adjust it to a particular time zone.
     This can be useful when displaying time information with different time zones in an application.
     */
    private fun Long.toHMM(timeZone: String):String{
        val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        dateFormat.timeZone = TimeZone.getTimeZone(timeZone)
        return dateFormat.format(Date(this * 1000))
    }

    private fun Long.toEEE(timeZone: String):String{
        val dateFormat = SimpleDateFormat("EEE", Locale.getDefault())
        dateFormat.timeZone = TimeZone.getTimeZone(timeZone)
        return dateFormat.format(Date(this * 1000))
    }

    private fun mapDailyWeather(daily:List<DailyWeather>, timeZone: String):List<DailyForecast>{
        return daily.map {
            DailyForecast(
                day = it.dt.toEEE(timeZone),
                temp = it.temp.day,
                icon = DrawableUtils.getIconForWeather(it.weather.firstOrNull()?.main.orEmpty())
            )
        }
    }
}