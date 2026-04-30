package com.salamhack.presentation.screen.addTransaction

import android.util.Log
import com.salamhack.data.source.local.LocalCategoriesDataSource
import com.salamhack.domain.entity.Category
import com.salamhack.domain.entity.InputType
import com.salamhack.domain.entity.TransactionType
import com.salamhack.domain.usecase.AddTransactionUseCase
import com.salamhack.domain.usecase.ParseTransactionUseCase
import com.salamhack.presentation.shared.utils.BaseViewModel

class AddTransactionViewModel(
    private val parseTransactionUseCase: ParseTransactionUseCase,
    private val addTransactionUseCase: AddTransactionUseCase
): BaseViewModel<AddTransactionUiState>(AddTransactionUiState()),
AddTransactionInteractionListener {

    private val userId = "550e8400-e29b-41d4-a716-446655440001"

    init {
        loadCategories(screenState.value.transactionType)
    }

    fun loadCategories(type: TransactionType) {
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

    override fun onTitleChange(title: String) {
        updateState(screenState.value.copy(titleInput = title, error = null))
    }

    override fun onAmountChange(amount: String) {
        updateState(screenState.value.copy(amountInput = amount, error = null))
    }

    override fun onSelectCategory(category: Category) {
        updateState(screenState.value.copy(selectedCategory = category, error = null))
    }

    override fun onClickBack() {
        navigateUp()
    }

    override fun onClickSmartInput() {
        updateState(screenState.value.copy(inputType = InputType.SmartInput))
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
        updateState(screenState.value.copy(inputType = type))
    }

    override fun onClickSmartAnalysis(text: String) {
        updateState(screenState.value.copy(isLoading = true))
        tryToExecute(
            onSuccess = { result ->
                updateState(
                    newState = screenState.value.copy(
                        isLoading = false,
                        parsedTransaction = result,
                        bottomSheet = screenState.value.bottomSheet.copy(isVisible = true)
                    )
                )
            },
            execute = { parseTransactionUseCase(text) },
            onError = { error ->
                updateState(screenState.value.copy(error = error.message, isLoading = false))
            }
        )
    }

    override fun onDismissBottomSheet() {
        updateState(
            screenState.value.copy(
                bottomSheet = screenState.value.bottomSheet.copy(isVisible = false)
            )
        )
    }

    override fun onClickConfirmAnalysis() {
        val parsed = screenState.value.parsedTransaction
        if (parsed != null) {
            val type = if (parsed.isIncome) TransactionType.INCOME else TransactionType.EXPENSE

            val extractedCategory = if (parsed.isIncome) {
                LocalCategoriesDataSource.getIncomeById(parsed.categoryId)
            } else {
                LocalCategoriesDataSource.getExpenseById(parsed.categoryId)
            }

            updateState(
                screenState.value.copy(
                    titleInput = parsed.title,
                    amountInput = parsed.amount.toString(),
                    transactionType = type,
                    inputType = InputType.ManualInput,
                    selectedCategory = extractedCategory,
                    bottomSheet = screenState.value.bottomSheet.copy(isVisible = false)
                )
            )
            loadCategories(type)
        }
    }

    override fun onClickEditText() {
        updateState(
            screenState.value.copy(
                bottomSheet = screenState.value.bottomSheet.copy(isVisible = false)
            )
        )
    }

    override fun onSmartInputTextChange(description: String) {
        updateState(screenState.value.copy(smartInputText = description))
    }

    override fun onClickSaveTransaction() {
        Log.d("AddTransactionViewModel", "Attempting to save transaction with state: ${screenState.value}")
        val state = screenState.value

        if (state.titleInput.isBlank() || state.amountInput.isBlank() || state.selectedCategory == null) {
            updateState(state.copy(error = "يرجى تعبئة جميع الحقول واختيار الفئة"))
            return
        }

        val typeString = if (state.transactionType == TransactionType.INCOME) "income" else "expense"
        val categoryIdString = state.selectedCategory.id

        tryToObserve(
            observe = {
                addTransactionUseCase(
                    userId = userId,
                    title = state.titleInput,
                    amount = state.amountInput,
                    type = typeString,
                    categoryId = categoryIdString
                )
            },
            onStart = {
                updateState(screenState.value.copy(isLoading = true, error = null))
            },
            onEach = { result ->
                result?.fold(
                    onSuccess = { transactionEntity ->
                        updateState(
                            screenState.value.copy(
                                isLoading = false,
                                isSuccess = true,
                                addedTransaction = transactionEntity
                            )
                        )
                        navigateUp()
                    },
                    onFailure = { error ->
                        updateState(
                            screenState.value.copy(
                                isLoading = false,
                                error = error.message ?: "حدث خطأ أثناء حفظ المعاملة"
                            )
                        )
                    }
                )
            },
            onError = {
                updateState(screenState.value.copy(isLoading = false, error = it.message))
            }
        )
    }
}