package com.salamhack.presentation.screen.addGoal

import com.salamhack.presentation.shared.components.PriorityLevel
import com.salamhack.presentation.shared.utils.BaseViewModel

class AddGoalViewModel(): BaseViewModel<AddGoalUiState>(AddGoalUiState()),
    AddGoalInteractionListener {

    override fun onSelectIcon(iconId: String) {
        updateState(screenState.value.copy(selectedIconId = iconId))
    }

    override fun onTitleChange(title: String) {
        updateState(screenState.value.copy(title = title))
    }

    override fun onAmountChange(amount: String) {
        updateState(screenState.value.copy(amount = amount))
    }

    override fun onDateChange(dateText: String) {
        updateState(
            screenState.value.copy(
                targetDateText = dateText,
            )
        )
    }

    override fun onSelectPriority(priority: PriorityLevel) {
        updateState(screenState.value.copy(selectedPriority = priority))
    }

    override fun onClickBack() {
        navigateUp()
    }

    override fun onClickCreateGoal() {
        val currentState = screenState.value
        updateState(
            newState = currentState.copy(
                isLoading = false,
                error = "ستتوفر هذه الميزة قريبا"
            )
        )
        navigateUp()
    }
}