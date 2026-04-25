package com.salamhack.presentation.shared.designSystem.color

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class AppColors(
    val bluePrimary: Color,
    val blueBackground: Color,
    val lightGreen: Color,
    val redWarning: Color,
    val redBackground: Color,
    val background: Color,
    val graySubTitles: Color,
    val grayNonActive: Color,
    val dark: Color,
    val white: Color,
    val orange: Color,
    val orangeBackground: Color,
)

val LocalAppColors = staticCompositionLocalOf { lightThemeColors }