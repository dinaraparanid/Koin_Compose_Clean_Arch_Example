package com.paranid5.koinmvvvmtest_compose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200
)

@JvmInline
value class AppColors(val value: Colors = DarkColorPalette)

val LocalAppColors = staticCompositionLocalOf { AppColors() }

@Composable
fun KoinMVVVMTest_ComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val appColors = AppColors(if (darkTheme) DarkColorPalette else LightColorPalette)

    CompositionLocalProvider(LocalAppColors provides appColors) {
        MaterialTheme(
            colors = appColors.value,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}