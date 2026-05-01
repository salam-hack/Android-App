package com.salamhack.presentation.screen.allGoals

import com.salamhack.presentation.navigation.Destinations
import com.salamhack.presentation.shared.components.GoalStatus
import com.salamhack.presentation.shared.utils.BaseViewModel

class AllGoalsViewModel(): BaseViewModel<AllGoalsUiState>(AllGoalsUiState()),
AllGoalsInteractionListener{

    override fun onClickBack() {
        navigateUp()
    }

    override fun onClickAddGoal() {
        navigate(Destinations.AddGoal)
    }

    override fun onSelectGoalStatus(status: GoalStatus) {
        updateState(
            newState = screenState.value.copy(
                selectedGoalStatus = status
            )
        )
    }

    override fun onClickGoalDetails() {
        navigate(Destinations.GoalDetails)
    }

}