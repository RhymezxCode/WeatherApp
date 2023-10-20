package com.zseni.weatherapp.data.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class HourlyUnits(
    @SerializedName("pressure_msl")
    val pressureMsl: String, // hPa
    @SerializedName("relativehumidity_2m")
    val relativehumidity2m: String, // %
    @SerializedName("temperature_2m")
    val temperature2m: String, // °C
    @SerializedName("time")
    val time: String, // iso8601
    @SerializedName("weathercode")
    val weathercode: String, // wmo code
    @SerializedName("windspeed_10m")
    val windspeed10m: String // km/h
)