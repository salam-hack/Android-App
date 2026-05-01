package com.salamhack.presentation.screen.more

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.R
import com.salamhack.presentation.shared.components.SettingsItem
import com.salamhack.presentation.shared.components.SettingsItemType
import com.salamhack.presentation.shared.components.UserProfileCard
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun MoreScreen(
    modifier: Modifier = Modifier,
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7FD))
            .statusBarsPadding()
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(195.dp)
                .background(Theme.colors.bluePrimary)
        )
        // blue section
        Image(
            painter = painterResource(id = R.drawable.login_bg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(195.dp)
        )
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                // title
                Text(
                    text = "الاعدادات",
                    style = Theme.textStyle.title.regular.copy(
                        fontSize = 18.sp,
                        color = Theme.colors.white,
                        textDirection = TextDirection.Rtl
                    ),
                    modifier = Modifier
                        .padding(top = 36.dp)
                        .align(Alignment.TopCenter)
                )

                // Back Button
                Box(
                    modifier = Modifier
                        .padding(top = 28.dp, end = 18.dp)
                        .size(44.dp)
                        .background(Theme.colors.white, shape = RoundedCornerShape(16.dp))
                        .align(Alignment.TopEnd)
                        .clickable{
//                            action.onClickBack()
                        },
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = null,
                        tint = Theme.colors.bluePrimary,
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
            }

            UserProfileCard(
                modifier = Modifier
                    .padding(top = 24.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp, horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                item {
                    SettingsHolder(
                        modifier = Modifier
                            .padding(top = 0.dp)
                    ) {
                        SettingsItem(
                            icon = R.drawable.ic_bell,
                            color = Theme.colors.bluePrimary,
                            title = "تنبيهات الميزانية الذكية",
                            description = "تجاوز الحد، فرص توفير",
                            onCheckedChange = {},
                            isCheck = true,
                            type = SettingsItemType.Notification
                        )
                        SettingsItem(
                            icon = R.drawable.ic_error,
                            color = Color(0xFFE7000B),
                            title = "تذكير الديون المستحقة",
                            description = "قبل الموعد بيومين",
                            onCheckedChange = {},
                            isCheck = true,
                            type = SettingsItemType.Notification
                        )
                        SettingsItem(
                            icon = R.drawable.ic_people,
                            color = Color(0xFFE17100),
                            title = "تنبيهات الجمعيات",
                            description = "مواعيد الدفع والقبض",
                            onCheckedChange = {},
                            isCheck = true,
                            type = SettingsItemType.Notification
                        )
                    }
                }

                item {
                    SettingsHolder(
                        title = "الإعدادات العامة",
                        modifier = Modifier
                            .padding(top = 0.dp)
                    ) {
                        SettingsItem(
                            icon = R.drawable.ic_language,
                            color = Color(0xFF45556C),
                            title = "لغة التطبيق",
                            onCheckedChange = {},
                            isCheck = true,
                            type = SettingsItemType.Language
                        )
                        SettingsItem(
                            icon = R.drawable.ic_moon,
                            color = Color(0xFF45556C),
                            title = "الوضع الليلي",
                            onCheckedChange = {},
                            isCheck = true,
                            type = SettingsItemType.Notification
                        )
                        SettingsItem(
                            icon = R.drawable.ic_person_avatar,
                            color = Color(0xFF45556C),
                            title = "إدارة الحساب",
                            onCheckedChange = {},
                            isCheck = true,
                            type = SettingsItemType.Normal
                        )
                    }
                }

                item {
                    SettingsHolder(
                        title = "الأمان والخصوصية",
                        modifier = Modifier
                            .padding(top = 0.dp)
                    ) {
                        SettingsItem(
                            icon = R.drawable.ic_finger,
                            color = Color(0xFF00C950),
                            title = "الدخول بالبصمة / Face ID",
                            description = "لحماية بياناتك المالية",
                            onCheckedChange = {},
                            isCheck = true,
                            type = SettingsItemType.Notification
                        )
                        SettingsItem(
                            icon = R.drawable.ic_shield,
                            color = Color(0xFF45556C),
                            title = "تغيير كلمة المرور",
                            onCheckedChange = {},
                            isCheck = true,
                            type = SettingsItemType.Normal
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SettingsHolder(
    modifier: Modifier = Modifier,
    title: String = "إعدادات الإشعارات",
    content: @Composable () -> Unit
){
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            style = Theme.textStyle.title.regular.copy(
                fontSize = 12.sp,
                color = Theme.colors.grayNonActive
            ),
            modifier = Modifier
                .padding(bottom = 12.dp, end = 8.dp)
                .align(Alignment.End)
        )
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(Theme.colors.white, shape = RoundedCornerShape(24.dp))
                .border(
                    width = 1.dp,
                    color = Color(0xFFF1F5F9),
                )
        ){
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(32.dp),

            ) {
                content()
            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    MoreScreen()
}