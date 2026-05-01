package com.salamhack.domain.entity

data class BalanceEntity(
    val currentBalance: Double = 0.0,
    val incomeThisMonth: Double = 0.0,
    val expensesThisMonth: Double = 0.0
)
