package com.salamhack.presentation.screen.allTransaction

import com.salamhack.presentation.shared.utils.BaseViewModel

class AllTransactionViewModel(): BaseViewModel<AllTransactionUiState>(AllTransactionUiState()), AllTransactionInteractionListener {
    override fun onClickBack() {
        navigateUp()
    }
}