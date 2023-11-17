package com.zseni.weatherapp.domain.model

enum class Units(val value:String, val tempLabel:String) {
    STANDARD("standard","ºF"),
    METRIC("metric","ºC"),
    IMPERIAL("imperial", "ºF")
}