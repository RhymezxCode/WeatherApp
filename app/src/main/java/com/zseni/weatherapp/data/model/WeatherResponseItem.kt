package com.zseni.weatherapp.data.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class WeatherResponseItem(
    @SerializedName("elevation")
    val elevation: Double, // 38.0
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double, // 0.23996829986572266
    @SerializedName("hourly")
    val hourly: Hourly,
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits,
    @SerializedName("latitude")
    val latitude: Double, // 52.52
    @SerializedName("longitude")
    val longitude: Double, // 13.419998
    @SerializedName("timezone")
    val timezone: String, // GMT
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String, // GMT
    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int // 0
)