package com.salamhack.presentation.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.textStyle.ibm
import com.salamhack.presentation.shared.designSystem.theme.Theme

sealed class AppButtonType {
    data object Primary : AppButtonType()
    data object Danger : AppButtonType()
    data object Ghost : AppButtonType()
}
@Composable
fun AppButton(
    text: String,
    modifier: Modifier = Modifier,
    type: AppButtonType = AppButtonType.Primary,
    icon: Int? = null,
    onClick: () -> Unit = {},
){

    val backgroundColor = when (type) {
        AppButtonType.Primary -> Theme.colors.bluePrimary
        AppButtonType.Danger -> Theme.colors.redWarning
        AppButtonType.Ghost -> Color(0xFFE1E3E4)
    }

    val textColor = when (type) {
        is AppButtonType.Primary -> Theme.colors.white
        is AppButtonType.Danger -> Theme.colors.white
        is AppButtonType.Ghost -> Theme.colors.dark
    }

    val modifierFinal = modifier
        .clip(RoundedCornerShape(12.dp))
        .background(backgroundColor)
        .fillMaxWidth()
        .clickable { onClick() }

    Box(
        modifier = modifierFinal
    ){
        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 14.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            if (icon != null){
                Icon(
                    painter = painterResource(icon),
                    contentDescription = "analyze",
                    tint = textColor,
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = ibm,
                color = textColor,
            )
        }
    }
}

@Preview
@Composable
private fun Preview(){
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        AppButton(
            text = "تحليل لأن",
            type = AppButtonType.Primary,
            icon = R.drawable.ic_security
        )
        AppButton(
            text = "حذف الرسالة",
            type = AppButtonType.Danger
        )
        AppButton(
            text = "حظر المرسل",
            type = AppButtonType.Ghost
        )
    }
}
