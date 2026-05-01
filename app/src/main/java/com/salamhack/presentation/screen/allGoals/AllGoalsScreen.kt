package com.salamhack.presentation.screen.allGoals

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.salamhack.R
import com.salamhack.presentation.shared.components.GoalStatusSelector
import com.salamhack.presentation.shared.components.TargetCard
import com.salamhack.presentation.shared.components.TotalWealth
import com.salamhack.presentation.shared.designSystem.theme.Theme
import org.koin.androidx.compose.koinViewModel

@Composable
fun AllGoalsScreen(
    viewModel: AllGoalsViewModel = koinViewModel()
){
    val state by viewModel.screenState.collectAsStateWithLifecycle()
    AllGoalsScreenContent(
        action = viewModel,
        state = state
    )
}

@Composable
fun AllGoalsScreenContent(
    modifier: Modifier = Modifier,
    action: AllGoalsInteractionListener,
    state: AllGoalsUiState
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
                .height(253.dp)
                .background(Theme.colors.bluePrimary)
        )
        // blue section
        Image(
            painter = painterResource(id = R.drawable.login_bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(253.dp)
        )

        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                // title
                Text(
                    text = "جميع الاهداف",
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

                item {
                    TotalWealth(
                        title = "جميع الاهداف",
                        amountText = "15,400",
                        currencyText = "اهداف نشطة",
                        secondCurrencyText = "هدف",
                        incomeLabel = "مكتمله",
                        incomeAmountText = "20,000",
                        expenseLabel = "ملغاه",
                        expenseAmountText = "4,600",
                        incomeIcon = R.drawable.ic_income,
                        expenseIcon = R.drawable.ic_expense,
                        modifier = Modifier.padding(top = 40.dp),
                    )
                }
                item {
                    GoalStatusSelector(
                        selectedStatus = state.selectedGoalStatus,
                        onStatusSelected = {
                            action.onSelectGoalStatus(it)
                        }
                    )
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .background(Color(0xFFF1F5F9), shape = CircleShape)
                                .size(44.dp)
                                .clickable{
                                    action.onClickAddGoal()
                                },
                            contentAlignment = Alignment.Center
                        ){
                            Icon(
                                painterResource(R.drawable.ic_add),
                                contentDescription = null,
                                tint = Theme.colors.bluePrimary,
                                modifier = Modifier
                                    .size(20.dp)
                            )
                        }
                        Text(
                            text = "أهدافي المالية",
                            style = Theme.textStyle.title.regular.copy(
                                fontSize = 18.sp,
                                color = Color(0xFF0F172B)
                            )
                        )
                    }
                }
                items(4) {
                    TargetCard(
                        title = "شراء MacBook Pro",
                        targetAmount = "80,000",
                        saverAmount = "20,000",
                        percentage = 25f,
                        icon = R.drawable.ic_laptop,
                        remainingMonths = "10",
                        modifier = Modifier.clickable {
                            action.onClickGoalDetails()
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    AllGoalsScreen()
}