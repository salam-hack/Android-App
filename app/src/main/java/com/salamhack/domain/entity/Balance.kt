package com.salamhack.domain.entity

data class Balance(
    val currentBalance: Double,
    val currency: String,
    val incomeThisMonth: Double,
    val expensesThisMonth: Double
)
