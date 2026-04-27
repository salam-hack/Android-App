package com.salamhack.domain.entity

data class HomeEntity(
    val user: User,
    val balance: Balance,
    val goals: List<Goal>,
    val smartAnalysis: List<SmartAnalysis>,
    val transactions: List<Transaction>
)
