package com.zseni.weatherapp.domain.model

enum class ExcludedData(val value:String) {
    CURRENT("current"),
    //HOURLY("hourly"),
    DAILY("daily"),
    MINUTELY("minutely"),
    ALERTS("alerts")
}