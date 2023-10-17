package com.zseni.weatherapp.data


import com.zseni.weatherapp.data.remote.WeatherData
import com.zseni.weatherapp.data.remote.WeatherDataDto
import com.zseni.weatherapp.data.remote.WeatherDto
import com.zseni.weatherapp.domain.weather.WeatherInfo
import com.zseni.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index:Int,
    val data:WeatherData
)
fun WeatherDataDto.toWeatherDataMap():Map<Int, List<WeatherData>>{
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode)
            )
        )
    }.groupBy {
        it.index/24
    }.mapValues {
        it.value.map { it.data }
    }
}

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
// Create a list to store weather data for 7 days
    val weatherDataFor7Days = mutableListOf<List<WeatherData>>()

//Iterate through the next 7 days
    for (i in 0 until 7){
        val currentDay = now.plusDays(i.toLong())
        val weatherDataForDay = weatherDataMap[i]?.filter {
            it.time.dayOfYear == currentDay.dayOfYear
        }
        weatherDataFor7Days.add(weatherDataForDay.orEmpty())
    }

    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if (now.minute >= 23 && now.minute >= 50) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}

//val weatherDataMap = weatherData.toWeatherDataMap()

