package com.jojalvo.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 *   @author jojalvo
 *   @since 18/4/23
 *   @email josealejandro025@gmail.com
 */
val DarkTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = RobotoFonts,
        fontWeight = FontWeight.Bold,
        color = White,
        fontSize = 28.sp
    ),
    displayMedium = TextStyle(
        fontFamily = RobotoFonts,
        fontWeight = FontWeight.Bold,
        color = White,
        fontSize = 21.sp
    ),
    displaySmall = TextStyle(
        fontFamily = RobotoFonts,
        fontWeight = FontWeight.SemiBold,
        color = White,
        fontSize = 18.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = RobotoFonts,
        fontWeight = FontWeight.Medium,
        color = White,
        fontSize = 15.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = RobotoFonts,
        fontWeight = FontWeight.Medium,
        color = White,
        fontSize = 18.sp
    ),
    titleLarge = TextStyle(
        fontFamily = RobotoFonts,
        fontWeight = FontWeight.Bold,
        color = White,
        fontSize = 16.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = RobotoFonts,
        fontWeight = FontWeight.Normal,
        color = White,
        fontSize = 14.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = RobotoFonts,
        fontWeight = FontWeight.Bold,
        color = White,
        fontSize = 14.sp
    ),
    titleMedium = TextStyle(
        fontFamily = RobotoFonts,
        fontWeight = FontWeight.Medium,
        color = White,
        fontSize = 14.sp
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        color = White,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)

// Set of light material typographies by default
val LightTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = RobotoFonts,
        fontWeight = FontWeight.Bold,
        color = Black,
        fontSize = 28.sp
    ),
    displayMedium = TextStyle(
        fontFamily = RobotoFonts,
        fontWeight = FontWeight.Bold,
        color = Black,
        fontSize = 21.sp
    ),
    displaySmall = TextStyle(
        fontFamily = RobotoFonts,
        fontWeight = FontWeight.SemiBold,
        color = Black,
        fontSize = 18.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = RobotoFonts,
        fontWeight = FontWeight.Medium,
        color = Black,
        fontSize = 15.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = RobotoFonts,
        fontWeight = FontWeight.Medium,
        color = Black,
        fontSize = 18.sp
    ),
    titleLarge = TextStyle(
        fontFamily = RobotoFonts,
        fontWeight = FontWeight.Bold,
        color = Black,
        fontSize = 16.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = RobotoFonts,
        fontWeight = FontWeight.Normal,
        color = Black,
        fontSize = 14.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = RobotoFonts,
        fontWeight = FontWeight.Bold,
        color = Black,
        fontSize = 14.sp
    ),
    titleMedium = TextStyle(
        fontFamily = RobotoFonts,
        fontWeight = FontWeight.Medium,
        color = Black,
        fontSize = 14.sp
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        color = Black,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)