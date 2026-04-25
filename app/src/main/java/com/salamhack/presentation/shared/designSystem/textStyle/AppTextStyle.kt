package com.salamhack.presentation.shared.designSystem.textStyle

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

data class AppTextStyle(
    val header: TextStyle,
    val title: SizedTitleTextStyle,
    val contentOne: TextStyle,
    val contentTwo: TextStyle,
)

data class SizedTitleTextStyle(
    val bold: TextStyle,
    val medium: TextStyle,
    val regular: TextStyle,
    val sub: TextStyle,
)

val LocalAppTextStyle = staticCompositionLocalOf { defaultTextStyle }