package com.salamhack.presentation.screen.allTransaction

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.salamhack.R
import com.salamhack.presentation.shared.components.TransactionItem
import com.salamhack.presentation.shared.designSystem.theme.Theme
import org.koin.androidx.compose.koinViewModel

@Composable
fun AllTransactionScreen(
    viewModel: AllTransactionViewModel = koinViewModel()
){
    val state by viewModel.screenState.collectAsStateWithLifecycle()
    AllTransactionScreenContent(
        action = viewModel,
        state = state
    )
}

@Composable
fun AllTransactionScreenContent(
    modifier: Modifier = Modifier,
    action: AllTransactionInteractionListener,
    state: AllTransactionUiState
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7FD))
            .statusBarsPadding()
    ){
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Theme.colors.bluePrimary)
                )
                // blue section
                Image(
                    painter = painterResource(id = R.drawable.login_bg),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )
                // title
                Text(
                    text = "المعاملات",
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
                            action.onClickBack()
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp, horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(20){
                    TransactionItem(
                        amount = "150",
                        date = "25 أكتوبر",
                        time = "09:00 ص",
                        title = "الراتب الشهري",
                        category = "دخل",
                        icon = R.drawable.ic_work,
                        isIncome = true,
                        color = Color(0xFF00A63E)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    AllTransactionScreen()
}
