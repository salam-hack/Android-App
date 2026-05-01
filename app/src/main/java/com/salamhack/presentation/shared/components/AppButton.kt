package com.salamhack.presentation.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
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
    data object Secondary : AppButtonType()
    data object Danger : AppButtonType()
    data object Ghost : AppButtonType()
    data object PrimaryOutline : AppButtonType()
    data object DangerSoft : AppButtonType()
    data object SecondarySoft : AppButtonType()
}

@Composable
fun AppButton(
    text: String,
    modifier: Modifier = Modifier,
    type: AppButtonType = AppButtonType.Primary,
    icon: Int? = null,
    onClick: () -> Unit = {},
    isLoading: Boolean = false
) {

    val backgroundColor = when (type) {
        AppButtonType.Primary -> Theme.colors.bluePrimary
        AppButtonType.Secondary -> Color.Transparent
        AppButtonType.Danger -> Theme.colors.redWarning
        AppButtonType.Ghost -> Color(0xFFE1E3E4)
        AppButtonType.PrimaryOutline -> Color.Transparent
        AppButtonType.DangerSoft -> Color(0xFFFEF2F2)
        AppButtonType.SecondarySoft -> Color(0xFFF8FAFC)
    }

    val textColor = when (type) {
        is AppButtonType.Primary -> Theme.colors.white
        is AppButtonType.Secondary -> Theme.colors.grayNonActive
        is AppButtonType.Danger -> Theme.colors.white
        is AppButtonType.Ghost -> Theme.colors.dark
        is AppButtonType.PrimaryOutline -> Theme.colors.bluePrimary
        is AppButtonType.DangerSoft -> Color(0xFFDC2626)
        is AppButtonType.SecondarySoft -> Color(0xFF475569)
    }

    val borderModifier = when (type) {
        AppButtonType.Secondary -> Modifier.border(2.dp, Color(0xFFE2E8F0), RoundedCornerShape(16.dp))
        AppButtonType.PrimaryOutline -> Modifier.border(1.dp, Theme.colors.bluePrimary, RoundedCornerShape(16.dp))
        AppButtonType.DangerSoft -> Modifier.border(1.dp, Color(0xFFFECACA), RoundedCornerShape(16.dp))
        AppButtonType.SecondarySoft -> Modifier.border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(16.dp))
        else -> Modifier
    }

    val modifierFinal = modifier
        .clip(RoundedCornerShape(16.dp))
        .background(backgroundColor)
        .fillMaxWidth()
        .clickable { onClick() }

    Box(
        modifier = modifierFinal.then(borderModifier)
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = textColor,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(8.dp)
            )
        } else {
            Row(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 14.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = text,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = ibm,
                    color = textColor,
                )
                if (icon != null) {
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = "icon",
                        tint = textColor,
                        modifier = Modifier.padding(start = 8.dp).size(20.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun SoftButtonsPreview() {
    androidx.compose.runtime.CompositionLocalProvider(androidx.compose.ui.platform.LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AppButton(
                text = "تعديل الهدف",
                type = AppButtonType.SecondarySoft,
                icon = android.R.drawable.ic_menu_edit,
                modifier = Modifier.weight(1f)
            )

            AppButton(
                text = "حذف الهدف",
                type = AppButtonType.DangerSoft,
                icon = android.R.drawable.ic_menu_delete,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun Preview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        AppButton(
            text = "تحليل لأن",
            type = AppButtonType.Primary,
            icon = android.R.drawable.ic_lock_idle_lock,
            isLoading = false
        )
        AppButton(
            text = "حذف الرسالة",
            type = AppButtonType.Secondary
        )
        AppButton(
            text = "حذف الرسالة",
            type = AppButtonType.Danger
        )
        AppButton(
            text = "حظر المرسل",
            type = AppButtonType.Ghost
        )
        AppButton(
            text = "اضافة معاملة",
            type = AppButtonType.PrimaryOutline
        )
    }
}