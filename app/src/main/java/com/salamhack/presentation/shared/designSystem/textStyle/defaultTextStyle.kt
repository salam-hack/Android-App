package com.salamhack.presentation.shared.designSystem.textStyle

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val defaultTextStyle = AppTextStyle(
    header = TextStyle(
//        fontFamily = ibm,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
    ),
    title = SizedTitleTextStyle(
        bold = TextStyle(
//            fontFamily = ibm,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        ),
        medium = TextStyle(
//            fontFamily = ibm,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
        ),
        regular = TextStyle(
//            fontFamily = ibm,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
        ),
        sub = TextStyle(
//            fontFamily = ibm,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
        ),
    ),
    contentOne = TextStyle(
//        fontFamily = ibm,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
    ),
    contentTwo = TextStyle(
//        fontFamily = ibm,
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal,
    )
)