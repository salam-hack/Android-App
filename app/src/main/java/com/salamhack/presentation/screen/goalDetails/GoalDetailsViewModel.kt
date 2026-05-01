package com.salamhack.presentation.screen.goalDetails

import com.salamhack.presentation.shared.utils.BaseViewModel

class GoalDetailsViewModel(): BaseViewModel<GoalDetailsUiState>(GoalDetailsUiState()),
GoalDetailsInteractionListener{
    override fun onClickBack() {
        navigateUp()
    }

    override fun onClickAddAmount() {

    }

    override fun onClickEditGoal() {

    }

    override fun onClickDeleteGoal() {

    }

    override fun onClickViewAllDeposits() {

    }
}