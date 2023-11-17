package com.zseni.weatherapp.data.api

import com.zseni.weatherapp.data.local.mappers.WeatherResponseMapper
import com.zseni.weatherapp.domain.model.WeatherData
import com.zseni.weatherapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
class RemoteDataSource @Inject constructor(
    private val weatherApi: WeatherApiService
) { suspend fun getWeatherData(
       latitude:Double,
       longitude:Double
   ):Flow<Resource<WeatherData>> = flow {
       try {
           emit(Resource.Loading())
           val response = weatherApi.getWeatherData(latitude, longitude)
           if (response.isSuccessful) {
               val weatherResponse = response.body()?.firstOrNull()

               if (weatherResponse != null) {
                   val weatherData =
                       WeatherResponseMapper.mapWeatherResponseToWeatherData(weatherResponse)
                   emit(Resource.Success(weatherData))
               } else {
                   emit(Resource.Error(Throwable("Empty response")))
               }
           } else {
               emit(Resource.Error(Throwable("Network Error")))
           }
       }catch (e:Exception){
           emit(Resource.Error(e))
       }
   }.flowOn(Dispatchers.IO)
}
