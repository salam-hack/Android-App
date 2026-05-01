package com.salamhack.presentation.screen.addGoal

import com.salamhack.presentation.shared.components.PriorityLevel

interface AddGoalInteractionListener {
    fun onSelectIcon(iconId: String)
    fun onTitleChange(title: String)
    fun onAmountChange(amount: String)
    fun onDateChange(dateText: String)
    fun onSelectPriority(priority: PriorityLevel)
    fun onClickBack()
    fun onClickCreateGoal()
}