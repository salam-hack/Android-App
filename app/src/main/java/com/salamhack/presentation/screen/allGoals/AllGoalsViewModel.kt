package com.salamhack.presentation.screen.allGoals

import com.salamhack.presentation.navigation.Destinations
import com.salamhack.presentation.shared.utils.BaseViewModel

class AllGoalsViewModel(): BaseViewModel<AllGoalsUiState>(AllGoalsUiState()),
AllGoalsInteractionListener{

    override fun onClickBack() {
        navigateUp()
    }

    override fun onClickAddGoal() {
        navigate(Destinations.AddGoal)
    }

    override fun onSelectGoalStatus() {
        TODO("Not yet implemented")
    }

    override fun onClickGoalDetails() {
        TODO("Not yet implemented")
    }

}