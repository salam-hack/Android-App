package com.salamhack.presentation.screen.goals

import com.salamhack.presentation.navigation.Destinations
import com.salamhack.presentation.shared.utils.BaseViewModel

class GoalsViewModel(): BaseViewModel<GoalsUiState>(GoalsUiState()), GoalsInteractionListener {
    override fun onClickNotification() {
        navigate(Destinations.Notification)
    }

    override fun onClickGoal() {
        TODO("Not yet implemented")
    }

    override fun onClickViewAllGoals() {
        TODO("Not yet implemented")
    }
}