package com.salamhack.presentation.screen.addTransaction

import android.view.SurfaceControl
import com.salamhack.domain.entity.Category
import com.salamhack.domain.entity.InputType
import com.salamhack.domain.entity.ParsedTransaction
import com.salamhack.domain.entity.TransactionType

data class AddTransactionUiState(
    val isLoading: Boolean = false,
    val error: String? = null,

    val transactionType: TransactionType = TransactionType.EXPENSE,
    val inputType: InputType = InputType.ManualInput,

    val categories: List<Category> = emptyList(),
    val selectedCategory: Category? = null,

    val transactionResult: SurfaceControl.Transaction? = null,

    val smartInputText: String = "",
    val parsedTransaction: ParsedTransaction? = null,

    val bottomSheet: BottomSheetUiState = BottomSheetUiState()
)

data class BottomSheetUiState(
    val isVisible: Boolean = false,
    val isLoading: Boolean = false,
)