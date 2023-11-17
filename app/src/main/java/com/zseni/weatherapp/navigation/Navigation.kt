package com.zseni.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zseni.weatherapp.presentation.component.WeatherCard
import com.zseni.weatherapp.presentation.component.WeatherState
import com.zseni.weatherapp.presentation.screens.SplashScreen

@Composable
fun WeatherNav(
    navController: NavHostController){
    val state = WeatherState()
    NavHost(
        navController = navController,
        startDestination = "splash_screen"){

        composable("splash_screen"){
            SplashScreen(navController = navController)
        }
        composable("weather card"){
            WeatherCard(state = state )
        }

    }
}