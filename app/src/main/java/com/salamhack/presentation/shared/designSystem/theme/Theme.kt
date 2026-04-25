package com.salamhack.presentation.shared.designSystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.salamhack.presentation.shared.designSystem.color.AppColors
import com.salamhack.presentation.shared.designSystem.color.LocalAppColors
import com.salamhack.presentation.shared.designSystem.textStyle.AppTextStyle
import com.salamhack.presentation.shared.designSystem.textStyle.LocalAppTextStyle

object Theme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current

    val textStyle: AppTextStyle
        @Composable
        @ReadOnlyComposable
        get() = LocalAppTextStyle.current
//
//    val radius: AppRadius
//        @Composable
//        @ReadOnlyComposable
//        get() = LocalAppRadius.current
}