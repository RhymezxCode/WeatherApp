package com.zseni.weatherapp.data.testapi

data class crosscheck(
    val elevation: Double,
    val generationtime_ms: Double,
   // val hourly: Hourly,
    //val hourly_units: HourlyUnits,
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val timezone_abbreviation: String,
    val utc_offset_seconds: Int
)