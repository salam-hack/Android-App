package com.salamhack.domain.entity

data class GoalEntity(
    val title: String,
    val isActive: Boolean,
    val progress: Double,
    val savedAmount: Double,
    val targetAmount: Double,
    val message: String
)