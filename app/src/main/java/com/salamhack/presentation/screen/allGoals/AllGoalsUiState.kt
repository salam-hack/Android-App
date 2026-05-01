package com.salamhack.presentation.screen.allGoals

import com.salamhack.presentation.shared.components.GoalStatus

data class AllGoalsUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val selectedGoalStatus: GoalStatus = GoalStatus.ACTIVE,
)
