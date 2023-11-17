package com.zseni.weatherapp.data.api


import com.zseni.weatherapp.BuildConfig
import com.zseni.weatherapp.util.Resource
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// Ask Awojide if you are to use response or your resource class
interface WeatherApiService {
   @GET("onecall?")
   suspend fun getWeatherData(
       @Query("lat") latitude:Double,
       @Query("lon") longitude:Double,
       @Query("appid") apiKey:String = BuildConfig.OPENAPI_KEY,
       @Query("units") units:String = "metric",
       @Query("exclude") exclude:String = "minutely"
   ):Response<List<WeatherResponse>>
}