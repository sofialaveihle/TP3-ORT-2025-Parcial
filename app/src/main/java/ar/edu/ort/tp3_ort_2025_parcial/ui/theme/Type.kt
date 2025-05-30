package ar.edu.ort.tp3_ort_2025_parcial.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import ar.edu.ort.tp3_ort_2025_parcial.R

// Set of Material typography styles to start with
val Typography = Typography(
    // Titulo
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_bold)),
        fontWeight = FontWeight.W600,
        fontSize = 40.sp,
        lineHeight = 56.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Start
    ),
    // Texto abajo del titulo
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 21.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Start
    ),
    // Placeholder inputs
    labelMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        lineHeight = 21.sp,
        letterSpacing = 0.5.sp
    ),
    // Dont have an account
    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        lineHeight = 19.2.sp,
        letterSpacing = 0.5.sp
    ),
    // Button1
    displayMedium = TextStyle(
        fontSize = 16.sp,
        lineHeight = 28.8.sp,
        fontFamily = FontFamily(Font(R.font.poppins_bold)),
        fontWeight = FontWeight(700),
        color = White,
        textAlign = TextAlign.Center,
    ),
    // Button2. Queda extraño usando esta
    labelSmall = TextStyle(
        fontSize = 10.sp,
        lineHeight = 19.2.sp,
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontWeight = FontWeight(500),
        letterSpacing = 0.5.sp
    )
)