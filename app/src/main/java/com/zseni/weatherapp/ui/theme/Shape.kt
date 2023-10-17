package com.zseni.weatherapp.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val shapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(10.dp),
    large = RoundedCornerShape(5.dp)
)

val BottomShape = Shapes(medium = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp, bottomEnd = 60.dp, bottomStart = 60.dp))
val SearchShape = Shapes(medium = RoundedCornerShape(12.dp))