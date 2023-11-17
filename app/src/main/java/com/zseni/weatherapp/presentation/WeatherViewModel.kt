package com.zseni.weatherapp.presentation


import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.lifecycle.viewModelScope
import com.zseni.weatherapp.domain.location.LocationTracker
import com.zseni.weatherapp.domain.model.WeatherData
import com.zseni.weatherapp.domain.repository.WeatherRepository
import com.zseni.weatherapp.domain.usecase.GetWeatherUseCase
import com.zseni.weatherapp.presentation.component.WeatherState
import com.zseni.weatherapp.util.Resource
import dagger.hilt.android.internal.Contexts.getApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.jvm.internal.Intrinsics.Kotlin

@HiltViewModel
class WeatherViewModel @Inject constructor(
   private val getWeatherUseCase: GetWeatherUseCase,
):ViewModel() {
   private var _weatherData = MutableLiveData<WeatherData>()
    val weatherData: LiveData<WeatherData> get() = _weatherData

    fun getWeatherData(
        context: Context,
        latitude:Double,
        longitude:Double
    ){
        viewModelScope.launch {
            _weatherData.postValue(
                getWeatherUseCase.execute(context,latitude,longitude)
            )
        }

    }


}





