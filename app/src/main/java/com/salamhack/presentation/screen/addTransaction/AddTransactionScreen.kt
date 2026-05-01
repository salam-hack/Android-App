package com.salamhack.presentation.screen.addTransaction

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.salamhack.R
import com.salamhack.data.source.local.LocalCategoriesDataSource
import com.salamhack.domain.entity.InputType
import com.salamhack.domain.entity.TransactionType
import com.salamhack.presentation.shared.components.AddTransactionTypes
import com.salamhack.presentation.shared.components.AppButton
import com.salamhack.presentation.shared.components.AppButtonType
import com.salamhack.presentation.shared.components.BottomSheet
import com.salamhack.presentation.shared.components.CategorySelection
import com.salamhack.presentation.shared.components.ErrorBanner
import com.salamhack.presentation.shared.components.InputTypeTabs
import com.salamhack.presentation.shared.components.LargeTransactionTextField
import com.salamhack.presentation.shared.components.MoneyTextField
import com.salamhack.presentation.shared.components.SmartInputResult
import com.salamhack.presentation.shared.components.TransactionNoteTextField
import com.salamhack.presentation.shared.designSystem.theme.Theme
import com.salamhack.presentation.uiModel.getCategoryIcon
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddTransactionScreen(
    viewModel: AddTransactionViewModel = koinViewModel()
) {
    val state by viewModel.screenState.collectAsStateWithLifecycle()
    AddTransactionScreenContent(
        action = viewModel,
        state = state
    )
}

@Composable
fun AddTransactionScreenContent(
    modifier: Modifier = Modifier,
    action: AddTransactionInteractionListener,
    state: AddTransactionUiState
) {
    val title = when (state.inputType) {
        InputType.SmartInput -> "الادخال الذكي"
        else -> "إضافة معاملة جديدة"
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7FD))
            .statusBarsPadding()
    ) {
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

        Text(
            text = title,
            style = Theme.textStyle.title.regular.copy(
                fontSize = 18.sp,
                color = Theme.colors.white,
                textDirection = TextDirection.Rtl
            ),
            modifier = Modifier
                .padding(top = 36.dp)
                .align(Alignment.TopCenter)
        )

        Box(
            modifier = Modifier
                .padding(top = 28.dp, end = 18.dp)
                .size(44.dp)
                .background(Theme.colors.white, shape = RoundedCornerShape(16.dp))
                .align(Alignment.TopEnd)
                .clickable { action.onClickBack() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = null,
                tint = Theme.colors.bluePrimary,
                modifier = Modifier.size(24.dp)
            )
        }

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
                    .padding(top = 32.dp)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    InputTypeTabs(
                        tabs = listOf(TransactionType.INCOME, TransactionType.EXPENSE),
                        selected = state.transactionType,
                        onTabSelected = { action.onSelectTransactionType(it) }
                    )
                }

                item {
                    AddTransactionTypes(
                        modifier = Modifier.padding(top = 24.dp),
                        selected = state.inputType,
                        onSelectedChange = { action.onSelectInputType(it) }
                    )
                }

                when (state.inputType) {
                    InputType.CameraInput, InputType.VoiceInput -> {
                        item {
                            Text(
                                text = "هذه الميزة ستتوفر قريبا ...",
                                style = Theme.textStyle.header.copy(
                                    color = Theme.colors.bluePrimary,
                                    textDirection = TextDirection.Rtl
                                ),
                                modifier = Modifier.padding(top = 40.dp)
                            )
                        }
                    }
                    InputType.ManualInput -> {
                        item {
                            Box(
                                modifier = Modifier
                                    .padding(top = 40.dp)
                                    .shadow(elevation = 1.dp, shape = RoundedCornerShape(12.dp))
                                    .background(Color.White, shape = RoundedCornerShape(12.dp))
                                    .clickable { action.onClickSmartInput() },
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_left_arrow),
                                        contentDescription = null,
                                        tint = Theme.colors.bluePrimary
                                    )
                                    Text(
                                        text = "ادخال ذكي",
                                        style = Theme.textStyle.contentOne.copy(
                                            fontWeight = FontWeight.SemiBold,
                                            textDirection = TextDirection.Rtl,
                                            color = Theme.colors.bluePrimary
                                        )
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                        }

                        item {
                            MoneyTextField(
                                placeholder = "200",
                                value = state.amountInput,
                                onTextChange = { action.onAmountChange(it) }
                            )
                        }

                        item {
                            CategorySelection(
                                modifier = Modifier.padding(top = 24.dp),
                                categories = state.categories,
                                selectedCategory = state.selectedCategory,
                                onCategorySelected = { action.onSelectCategory(it) }
                            )
                        }

                        item {
                            TransactionNoteTextField(
                                modifier = Modifier.padding(top = 24.dp),
                                value = state.titleInput,
                                onValueChange = { action.onTitleChange(it) }
                            )
                        }

                        if (state.error != null) {
                            item {
                                ErrorBanner(
                                    modifier = Modifier.padding(top = 40.dp),
                                    message = state.error
                                )
                            }
                        }

                        item {
                            AppButton(
                                text = "حفظ المعاملة",
                                type = AppButtonType.Primary,
                                modifier = Modifier.padding(vertical = 40.dp),
                                onClick = { action.onClickSaveTransaction() },
                                isLoading = state.isLoading
                            )
                        }
                    }
                    InputType.SmartInput -> {
                        item {
                            LargeTransactionTextField(
                                modifier = Modifier
                                    .padding(top = 40.dp)
                                    .fillParentMaxHeight(0.4f)
                                    .fillMaxWidth(),
                                value = state.smartInputText,
                                onValueChange = { action.onSmartInputTextChange(it) },
                            )
                        }

                        item {
                            AppButton(
                                text = "تحليل بالذكاء الاصطناعي",
                                type = AppButtonType.Primary,
                                icon = R.drawable.ic_magic,
                                modifier = Modifier.padding(vertical = 40.dp),
                                isLoading = state.isLoading,
                                onClick = { action.onClickSmartAnalysis(state.smartInputText) }
                            )
                        }
                    }
                }
            }
        }

        BottomSheet(
            show = state.bottomSheet.isVisible,
            onDismiss = { action.onDismissBottomSheet() },
        ) {
            Column {
                SmartInputResult(
                    isIncome = state.parsedTransaction?.isIncome == true,
                    amount = state.parsedTransaction?.amount?.toString() ?: "",
                    categoryIcon = getCategoryIcon(state.parsedTransaction?.categoryId ?: ""),
                    category = if (state.parsedTransaction?.isIncome == true) {
                        LocalCategoriesDataSource.getIncomeById(state.parsedTransaction.categoryId)?.name ?: "غير محدد"
                    } else {
                        LocalCategoriesDataSource.getExpenseById(state.parsedTransaction?.categoryId ?: "")?.name ?: "غير محدد"
                    },
                    date = state.parsedTransaction?.date ?: "",
                    note = state.parsedTransaction?.title ?: ""
                )
                AppButton(
                    text = "تأكيد الاستخراج",
                    type = AppButtonType.Primary,
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .padding(horizontal = 20.dp)
                        .align(Alignment.CenterHorizontally),
                    onClick = { action.onClickConfirmAnalysis() }
                )
                AppButton(
                    text = "تعديل النص",
                    type = AppButtonType.Secondary,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .padding(horizontal = 20.dp)
                        .align(Alignment.CenterHorizontally),
                    onClick = { action.onClickEditText() }
                )
            }
        }
    }
}