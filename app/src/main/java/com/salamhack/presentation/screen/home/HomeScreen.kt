package com.salamhack.presentation.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.salamhack.R
import com.salamhack.presentation.shared.components.SmartAnalysisCard
import com.salamhack.presentation.shared.components.TargetCard
import com.salamhack.presentation.shared.components.TotalWealth
import com.salamhack.presentation.shared.components.TransactionItem
import com.salamhack.presentation.shared.designSystem.theme.Theme
import com.salamhack.presentation.uiModel.getCategoryIcon
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
){
    val state by viewModel.screenState.collectAsStateWithLifecycle()
    HomeScreenContent(
        action = viewModel,
        state = state
    )
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    action: HomeInteractionListener,
    state: HomeUiState
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7FD))
            .statusBarsPadding()
    ){
        // blue section
        Image(
            painter = painterResource(id = R.drawable.login_bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(253.dp)
        )
        Box(
            modifier = Modifier
            .fillMaxWidth()
            .height(253.dp)
            .background(Theme.colors.bluePrimary.copy(alpha = 0.8f))
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 28.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                // notification
                Box(
                    modifier = Modifier
                        .background(Theme.colors.white, shape = RoundedCornerShape(16.dp))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img_notification),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(10.dp)
                            .size(20.dp)
                    )
                }
                Row {
                    Column(
                        modifier = Modifier
                            .padding(end = 8.dp),
                        horizontalAlignment = Alignment.End,
                    ) {
                        Text(
                            text = "مرحبا بك",
                            style = Theme.textStyle.title.medium.copy(
                                color = Theme.colors.blueBackground,
                                fontSize = 12.sp,
                            )
                        )
                        Text(
                            text = state.data?.user?.name ?: "أمير يسري",
                            style = Theme.textStyle.header.copy(
                                color = Theme.colors.white,
                            )
                        )
                    }
                    // profile picture
                    Box{
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(54.dp)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.profile_pic),
                                contentDescription = null
                            )
                        }

                        // online
                        Box(
                            modifier = Modifier
                                .size(14.dp)
                                .clip(CircleShape)
                                .background(Color.Green)
                                .border(2.dp, Theme.colors.bluePrimary, CircleShape)
                                .align(Alignment.BottomEnd)
                        )
                    }

                }
            }



            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                item {
                    TotalWealth(
                        title = "إجمالي الرصيد الحالي",
                        amountText = state.data?.balance?.currentBalance.toString(), // "15,400"
                        currencyText = "ج.م",
                        incomeLabel = "الدخل هذا الشهر",
                        incomeAmountText = state.data?.balance?.incomeThisMonth.toString(), // "20,000"
                        expenseLabel = "المصروفات",
                        expenseAmountText = state.data?.balance?.expensesThisMonth.toString(), // "4,600"
                        incomeIcon = R.drawable.ic_income,
                        expenseIcon = R.drawable.ic_expense,
                        modifier = Modifier.padding(top = 40.dp)
                    )
                }

                item {
                    val goal = state.data?.goals?.first()
                    TargetCard(
                        title = goal?.title ?: "شراء MacBook Pro", // "شراء MacBook Pro"
                        targetAmount = goal?.targetAmount.toString(), // "80,000"
                        saverAmount = goal?.savedAmount.toString(), // "20,000"
                        percentage = (goal?.progress?.toFloat()?.times(100f)) ?: 0f, // goal?.progress ?: 0f
                        icon = R.drawable.ic_laptop,
                        description = goal?.message ?: ""
                    )
                }
                if(state.data?.smartAnalysis?.isEmpty() != true){
                    item {
                        val smartAnalysis = state.data?.smartAnalysis?.first()
                        SmartAnalysisCard(
                            description = smartAnalysis?.description ?: "إنفاقك على الترفيه أقل هذا الأسبوع. يمكنك إضافة",
                            amount = 500,
                            trackedItemTitle = "Mackbook",
                            onClickAdd = {}
                        )
                    }
                }
                item {
                    val transactions = state.data?.transactions ?: emptyList()

                    TransactionBoxHolder(
                        onClickButton = {
                            action.onClickViewAllTransaction()
                        }
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(20.dp)
                        ) {
                            transactions.forEach { transaction ->
                                TransactionItem(
                                    amount = transaction.amount.toString(),
                                    date = transaction.date,
                                    time = transaction.date,
                                    title = transaction.title,
                                    category = transaction.title,
                                    icon = getCategoryIcon(transaction.categoryId),
                                    isIncome = transaction.type == "income",
                                    color = Theme.colors.bluePrimary
                                )
                            }
                            OutlinedButton(
                                onClick = {
                                    action.onClickAddTransaction()
                                },
                                modifier = modifier
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(12.dp),
                                border = BorderStroke(1.dp, Theme.colors.bluePrimary),
                            ) {
                                Text(
                                    text = "اضافة معاملة",
                                    style = Theme.textStyle.title.regular.copy(
                                        color = Theme.colors.bluePrimary,
                                    ),
                                    modifier = Modifier
                                        .padding(vertical = 8.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

    }
}

@Composable
fun TransactionBoxHolder(
    modifier: Modifier = Modifier,
    title: String = "أحدث المعاملات",
    buttonText: String = "عرض الكل",
    onClickButton: () -> Unit = {},
    content: @Composable () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Theme.colors.white, shape = RoundedCornerShape(24.dp))
            .padding(horizontal = 16.dp , vertical = 18.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(
                modifier = Modifier
                    .background(Theme.colors.bluePrimary.copy(alpha = 0.1f), shape = CircleShape)
                    .clickable{
                        onClickButton()
                    }
            ){
                Text(
                    text = buttonText,
                    style = Theme.textStyle.title.regular.copy(
                        fontSize = 12.sp,
                        color = Theme.colors.bluePrimary,
                    ),
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
            Text(
                text = title,
                style = Theme.textStyle.title.regular.copy(
                    fontSize = 18.sp,
                    color = Theme.colors.bluePrimary,
                )
            )
        }
        content()
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Preview(){
    HomeScreen()
}