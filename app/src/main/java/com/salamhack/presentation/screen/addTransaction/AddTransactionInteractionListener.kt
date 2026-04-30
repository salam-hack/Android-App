package com.salamhack.presentation.screen.addTransaction

import com.salamhack.domain.entity.Category
import com.salamhack.domain.entity.InputType
import com.salamhack.domain.entity.TransactionType

interface AddTransactionInteractionListener {
    fun onTitleChange(title: String)
    fun onAmountChange(amount: String)
    fun onSelectCategory(category: Category)
    fun onClickBack()
    fun onClickSmartInput()
    fun onSelectTransactionType(type: TransactionType)
    fun onSelectInputType(type: InputType)
    fun onClickSmartAnalysis(text: String)
    fun onDismissBottomSheet()
    fun onClickConfirmAnalysis()
    fun onClickEditText()
    fun onSmartInputTextChange(description: String)
    fun onClickSaveTransaction()
}