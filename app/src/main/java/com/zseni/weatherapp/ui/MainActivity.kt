package com.zseni.weatherapp.ui

import android.Manifest
import android.os.Bundle
import com.zseni.weatherapp.navigation.WeatherNav
import com.zseni.weatherapp.presentation.component.WeatherCard
import com.zseni.weatherapp.presentation.component.WeatherState
import com.zseni.weatherapp.presentation.WeatherViewModel
import com.zseni.weatherapp.ui.theme.WeatherAppTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@
class MainActivity : ComponentActivity() {
    private val viewModel:WeatherViewModel by viewModels()
    private lateinit var  permissionLauncher:ActivityResultLauncher<Array<String>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ))
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.onPrimary)
                ){
                    WeatherCard(
                        state = viewModel.,
                        modifier = Modifier.background(MaterialTheme.colorScheme.onPrimary))
                    WeatherNav(navController = rememberNavController())

                }


//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    WeatherNav(navController = rememberNavController())
//                }

            }
        }
    }


}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val state = WeatherState()
    //SplashScreen()
    WeatherCard(state = state)
}