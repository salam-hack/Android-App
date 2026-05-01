package com.salamhack.presentation.screen.allGoals

import com.salamhack.presentation.shared.components.GoalStatus

interface AllGoalsInteractionListener {
    fun onClickBack()
    fun onClickAddGoal()
    fun onSelectGoalStatus(status: GoalStatus)
    fun onClickGoalDetails()
}