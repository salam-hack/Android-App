package com.salamhack.presentation.screen.addGoal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.R
import com.salamhack.presentation.shared.components.GoalIcon
import com.salamhack.presentation.shared.components.GoalIconSelector
import com.salamhack.presentation.shared.components.MoneyTextField
import com.salamhack.presentation.shared.components.TransactionNoteTextField
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun AddGoalScreen(){
    AddGoalScreenContent()
}

@Composable
fun AddGoalScreenContent(
    modifier: Modifier = Modifier,
){
    val mockIcons = listOf(
        GoalIcon("car", R.drawable.ic_car, Color(0xFFB89020)),
        GoalIcon("home", R.drawable.ic_home, Color(0xFF45556C)),
        GoalIcon("laptop", R.drawable.ic_laptop, Theme.colors.bluePrimary),
        GoalIcon("plane", R.drawable.ic_travel, Color(0xFF2B7FFF)),
        GoalIcon("diamond", R.drawable.ic_diamond, Theme.colors.lightGreen),
        GoalIcon("education", R.drawable.ic_edu, Color(0xFF9810FA))
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7FD))
            .statusBarsPadding()
    ){
        // blue section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(253.dp)
                .background(Theme.colors.bluePrimary)
        )
        Image(
            painter = painterResource(id = R.drawable.login_bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(253.dp)
        )

        // title
        Text(
            text = "إضافة هدف جديد",
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
                .align(Alignment.TopEnd),
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

        //body
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topEnd = 32.dp, topStart = 32.dp))
                .background(Color.White)
                .align(Alignment.BottomCenter)
                .padding(horizontal = 16.dp)
                .fillMaxHeight(0.8f)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                item {
                    GoalIconSelector(
                        title = "اختر أيقونة للهدف",
                        icons = mockIcons,
                        selectedIconId = "",
                        onIconSelected = {},
                        modifier = Modifier
                            .padding(top = 32.dp),
                    )
                }
                item {
                    TransactionNoteTextField(
                        modifier = Modifier.padding(top = 24.dp),
                        value = "",
                        onValueChange = {  },
                        label = "اسم الهدف",
                        placeholder = "سيارة أحلامي",
                        icon = null
                    )
                }
                item {
                    Box(
                        modifier = Modifier
                            .background(Color(0xFFEFF6FF), shape = RoundedCornerShape(16.dp))
                            .border(
                                width = 1.dp,
                                color = Color(0xFFDBEAFE),
                                shape = RoundedCornerShape(16.dp)
                            )
                            .fillMaxWidth()
                    ){
                        MoneyTextField(
                            placeholder = "200",
                            value = "",
                            onTextChange = {  },
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(20.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    AddGoalScreen()
}