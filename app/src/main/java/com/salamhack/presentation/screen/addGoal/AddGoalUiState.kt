package com.salamhack.presentation.screen.addGoal

import com.salamhack.presentation.shared.components.PriorityLevel

data class AddGoalUiState(
    val isLoading: Boolean = false,
    val error: String? = null,

    val selectedIconId: String = "car",
    val title: String = "",
    val amount: String = "",
    val targetDateText: String = "ديسمبر 2025",
    val remainingTimeText: String = "متبقي 20 شهر",
    val selectedPriority: PriorityLevel = PriorityLevel.HIGH
)