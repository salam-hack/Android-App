package com.salamhack.presentation.screen.chatBotHistory

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.salamhack.presentation.shared.components.ChatCard
import com.salamhack.presentation.shared.components.SearchTextField
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun ChatBotHistoryScreen(){
    ChatBotHistoryScreenContent()
}

@Composable
fun ChatBotHistoryScreenContent(
    modifier: Modifier = Modifier,
){
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
                .height(170.dp)
                .background(Theme.colors.bluePrimary)
        )
        Image(
            painter = painterResource(id = R.drawable.login_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 56.dp),
            ) {
                // title
                Text(
                    text = "سجل المحادثات",
                    style = Theme.textStyle.title.regular.copy(
                        fontSize = 18.sp,
                        color = Theme.colors.white,
                        textDirection = TextDirection.Rtl
                    ),
                    modifier = Modifier
                        .align(Alignment.Center)
                )

                // Back Button
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .align(Alignment.CenterEnd)
                        .background(Theme.colors.white, shape = RoundedCornerShape(16.dp))
                        .clickable {
//                    action.onClickBack()
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

            SearchTextField(
                modifier = Modifier
                    .padding(top = 40.dp),
                query = "",
                onQueryChange = {

                }
            )

            LazyColumn(
                modifier = Modifier
                    .padding(top = 24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(10) {
                    ChatCard(
                        icon = R.drawable.ic_calender,
                        title = "تحليل المصروفات الأسبوعية",
                        description = " ج.م على المطاعم هذا الأسبوع وهو أعلى %.151,500لقد أنفقت من المعتاد بنسبة",
                        color = Color(0xFFE17100),
                        time = "09:30 ص",
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    ChatBotHistoryScreen()
}