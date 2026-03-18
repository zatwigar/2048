package com.example.truckmarket.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val TruckMarketColorScheme = darkColorScheme(
    primary = AccentOrange,
    background = BackgroundBlack,
    surface = SurfaceDark,
    onPrimary = TextPrimary,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
    secondary = SurfaceDarkSecondary,
    tertiary = SurfaceDarkTertiary,
)

@Composable
fun TruckMarketTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = TruckMarketColorScheme,
        typography = AppTypography,
        content = content,
    )
}
