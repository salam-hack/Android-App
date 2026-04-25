package com.salamhack.presentation.shared.designSystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import com.salamhack.presentation.shared.designSystem.color.LocalAppColors
import com.salamhack.presentation.shared.designSystem.color.darkThemeColors
import com.salamhack.presentation.shared.designSystem.color.lightThemeColors
import com.salamhack.presentation.shared.designSystem.textStyle.LocalAppTextStyle
import com.salamhack.presentation.shared.designSystem.textStyle.defaultTextStyle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@Composable
fun AppTheme(
    isDarkTheme: Flow<Boolean> = flowOf(false),
    content: @Composable () -> Unit
) {
    val isInDarkTheme = isDarkTheme.collectAsState(initial = isSystemInDarkTheme())
    val colors = if (isInDarkTheme.value) darkThemeColors else lightThemeColors

    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppTextStyle provides defaultTextStyle,
//        LocalAppRadius provides defaultAppRadius
    ){
        content()
    }
}