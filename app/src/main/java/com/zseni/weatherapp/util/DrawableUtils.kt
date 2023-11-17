package com.zseni.weatherapp.util

import androidx.annotation.DrawableRes
import com.zseni.weatherapp.R
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

/**
These method get the background based on the time of the day
(getBackgroundBasedOnTime) and weather(getIconForWeather)
 */
object DrawableUtils {

    @DrawableRes
    fun getBackgroundBasedOnTime(timestamp:Long, timezone:String):Int{
        val calender = Calendar.getInstance()
        calender.timeInMillis = timestamp * 1000
        calender.timeZone = TimeZone.getTimeZone(timezone)
        return when(calender.get(Calendar.HOUR_OF_DAY)){
            in 5..9 -> R.drawable.bg_morning
            in 10..17 -> R.drawable.bg_day
            in 18..19 -> R.drawable.bg_evening
            else -> R.drawable.bg_night
        }
    }

    @DrawableRes
    fun getIconForWeather(weatherMain:String):Int{
        return when (weatherMain.lowercase(Locale.ROOT)){
            "clouds", "drizzle" -> R.drawable.ic_cloudy_day
            "rain" -> R.drawable.ic_rain
            "snow" -> R.drawable.ic_snow
            "thunderstorm" -> R.drawable.ic_thunderstorm
            "fog","mist","smoke","haze","dust","sand","ash","squall" -> R.drawable.ic_fog
            "tornado" -> R.drawable.ic_tornado
            else -> R.drawable.ic_clear_day
        }
    }
}