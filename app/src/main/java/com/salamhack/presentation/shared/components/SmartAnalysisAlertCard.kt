package com.salamhack.presentation.shared.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun SmartAnalysisAlertCard(
    modifier: Modifier = Modifier,
    onClickButton: () -> Unit = {}
) {
    val borderColor = Color(0xFFFFEDD5)
    val cardBackground = Color(0xFFFFFFFF)

    val iconBackgroundColor = Color(0xFFFEF3C6)
    val iconTintColor = Color(0xFFE17100)

    val titleColor = Color(0xFF973C00)
    val subtitleColor = Color(0xFF92400E)
    val buttonBorderColor = Color(0xFFFEE685)

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(color = cardBackground, shape = RoundedCornerShape(24.dp))
                .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(24.dp))
                .padding(20.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(color = iconBackgroundColor, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_warning),
                        contentDescription = "تنبيه",
                        tint = iconTintColor,
                        modifier = Modifier.size(22.dp)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "تنبيه ذكي",
                        style = Theme.textStyle.title.sub.copy(
                            color = titleColor
                        ),
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "مصاريفك هذا الأسبوع مرتفعة. هذا قد يؤخر وصولك لهدف (MacBook Pro) بشهر إضافي.",
                        style = Theme.textStyle.title.sub.copy(
                            color = subtitleColor
                        ),
                        lineHeight = 22.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedButton(
                onClick = { onClickButton() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, buttonBorderColor),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = titleColor
                )
            ) {
                Text(
                    text = "تعديل خطة الإنفاق",
                    style = Theme.textStyle.title.sub.copy(
                        color = titleColor
                    ),
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    SmartAnalysisAlertCard()
}