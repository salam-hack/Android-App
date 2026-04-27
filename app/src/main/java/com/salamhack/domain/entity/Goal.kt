package com.salamhack.domain.entity

data class Goal(
    val title: String,
    val progress: Float,
    val savedAmount: Double,
    val targetAmount: Double,
    val message: String
)