package com.salamhack.presentation.screen.addTransaction

import android.util.Log
import com.salamhack.data.source.local.LocalCategoriesDataSource
import com.salamhack.domain.entity.Category
import com.salamhack.domain.entity.InputType
import com.salamhack.domain.entity.TransactionType
import com.salamhack.domain.usecase.ParseTransactionUseCase
import com.salamhack.presentation.shared.utils.BaseViewModel

class AddTransactionViewModel(
    private val parseTransactionUseCase: ParseTransactionUseCase,
): BaseViewModel<AddTransactionUiState>(AddTransactionUiState()),
AddTransactionInteractionListener {

    init {
        loadCategories(screenState.value.transactionType)
    }

    fun loadCategories(type: TransactionType){
        val categories = when (type) {
            TransactionType.INCOME -> LocalCategoriesDataSource.income
            TransactionType.EXPENSE -> LocalCategoriesDataSource.expense
        }
        updateState(
            newState = screenState.value.copy(
                categories = categories
            )
        )
    }

    override fun onSelectCategory(category: Category) {
        updateState(
            screenState.value.copy(
                selectedCategory = category
            )
        )
    }

    override fun onClickBack() {
        navigateUp()
    }

    override fun onClickSmartInput() {
        updateState(
            newState = screenState.value.copy(
                inputType = InputType.SmartInput
            )
        )
    }

    override fun onSelectTransactionType(type: TransactionType) {
        updateState(
            newState = screenState.value.copy(
                transactionType = type,
                selectedCategory = null
            )
        )
        loadCategories(type)
    }

    override fun onSelectInputType(type: InputType) {
        updateState(
            newState = screenState.value.copy(
                inputType = type
            )
        )
    }

    override fun onClickSmartAnalysis(text: String) {
        updateState(
            newState = screenState.value.copy(
                isLoading = true,
            )
        )
        tryToExecute(
            onSuccess = { result ->
                Log.d("SmartAnalysis", "Result: $result")
                updateState(
                    newState = screenState.value.copy(
                        isLoading = false,
                        parsedTransaction = result,
                        bottomSheet = screenState.value.bottomSheet.copy(
                            isVisible = true
                        )
                    )
                )
            },
            execute = {
                parseTransactionUseCase(text)
            },
            onError = { error ->
                updateState(
                    newState = screenState.value.copy(
                        error = error.message
                    )
                )
            }
        )

    }

    override fun onDismissBottomSheet() {
        updateState(
            newState = screenState.value.copy(
                bottomSheet = screenState.value.bottomSheet.copy(
                    isVisible = false
                )
            )
        )
    }

    override fun onClickConfirmAnalysis() {
        updateState(
            newState = screenState.value.copy(
                inputType = InputType.ManualInput,
                bottomSheet = screenState.value.bottomSheet.copy(
                    isVisible = false
                ),
            )
        )
    }


    override fun onClickEditText() {
        updateState(
            newState = screenState.value.copy(
                bottomSheet = screenState.value.bottomSheet.copy(
                    isVisible = false
                )
            )
        )
    }

    override fun onSmartInputTextChange(description: String) {
        updateState(
            newState = screenState.value.copy(
                smartInputText = description
            )
        )
    }

}