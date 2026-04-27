package com.salamhack.data.remote.dto

data class GoalDto(
    val title: String,
    val isActive: Boolean,
    val progress: Double,
    val savedAmount: Double,
    val targetAmount: Double,
    val estimatedDate: String,
    val message: String
)