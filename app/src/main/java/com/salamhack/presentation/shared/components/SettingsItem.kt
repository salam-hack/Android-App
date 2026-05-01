package com.salamhack.presentation.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.theme.Theme

sealed class SettingsItemType{
    data object Notification : SettingsItemType()
    data object Language : SettingsItemType()
    data object Normal : SettingsItemType()
}

@Composable
fun SettingsItem(
    modifier: Modifier = Modifier,
    icon: Int = R.drawable.ic_notification,
    color: Color = Color(0xFF0F3A70),
    title: String = "تنبيهات الميزانية الذكية",
    subTitle: String = "العربية",
    description: String? = null,
    onCheckedChange: (Boolean) -> Unit = {},
    onClick: () -> Unit = {},
    isCheck: Boolean = false,
    type: SettingsItemType = SettingsItemType.Language
){

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                when (type){
                    is SettingsItemType.Normal -> { onClick() }
                    is SettingsItemType.Language -> { onClick() }
                    else -> {}
                }
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        when (type) {
            is SettingsItemType.Normal -> {
                Icon(
                    painter = painterResource(id = R.drawable.ic_left_arrow),
                    contentDescription = null,
                    tint = Color(0xFF90A1B9)
                )
            }
            is SettingsItemType.Language -> {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.ic_left_arrow),
                        contentDescription = null,
                        tint = Color(0xFF90A1B9),
                        modifier = Modifier.size(16.dp)
                    )
                    Box(
                        modifier = Modifier
                            .background(Color(0xFFEFF6FF), shape = RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = subTitle,
                            style = Theme.textStyle.title.sub.copy(
                                fontSize = 11.sp,
                                color = Color(0xFF0F172B)
                            ),
                            modifier = Modifier
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }
            is SettingsItemType.Notification -> {
                AppSwitch(
                    checked = isCheck,
                    onCheckedChange = { onCheckedChange(it) },
                    modifier = Modifier,
                    activeColor = color,
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.End,
            ) {
                Text(
                    text = title,
                    style = Theme.textStyle.title.sub.copy(
                        color = Color(0xFF0F172B)
                    )
                )
                if (description != null) {
                    Text(
                        text = description,
                        style = Theme.textStyle.title.sub.copy(
                            fontSize = 11.sp,
                            color = Color(0xFF62748E)
                        )
                    )
                }
            }

            Box(
                modifier = Modifier
                    .background(color.copy(alpha = 0.2f), shape = RoundedCornerShape(12.dp))
                    .size(40.dp),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = color
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    SettingsItem()
}