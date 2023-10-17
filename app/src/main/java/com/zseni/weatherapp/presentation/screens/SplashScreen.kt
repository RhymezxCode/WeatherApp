package com.zseni.weatherapp.presentation.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zseni.weatherapp.R
import com.zseni.weatherapp.ui.theme.BottomShape
import com.zseni.weatherapp.ui.theme.ReemKufi
import com.zseni.weatherapp.ui.theme.seed
import com.zseni.weatherapp.ui.theme.textColour
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    val annotatedString = AnnotatedString.Builder(stringResource(id = R.string.annot))
        .apply {
            addStyle(
                SpanStyle(
                    color = textColour,
                    fontSize = 30.sp
                ),0,4
            )
        }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondary)) {
        Box(
            modifier = Modifier
                .padding(horizontal = 40.dp)
                .padding(top = 100.dp),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.sky) ,
                contentDescription = stringResource(id = R.string.splash_txt),
                modifier = Modifier.size(300.dp)
                )
        }
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .fillMaxSize()
        ){
            Card(
                modifier = Modifier
                    .clip(shape = BottomShape.medium)
                    .fillMaxWidth()
                    .height(350.dp)
                    .padding(10.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray
                )

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 40.dp)
                        .padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(
                        annotatedString.toAnnotatedString(),
                        fontFamily = ReemKufi,
                        fontSize = 28.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(text = stringResource(id = R.string.splash_txt),
                        fontFamily = ReemKufi,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        color = seed
                    )
                    Button(onClick = { /*TODO*/ }
                    ){
                        Text(text = "Get Started")

                    }
                }

            }
        }

    }
    val scale = remember{Animatable(0f)}
    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(1000L)
        navController.navigate("weather card")
    }


}

@Preview
@Composable
fun PreviewSplashScreen(){
    val navController = rememberNavController()
    SplashScreen(navController)
}