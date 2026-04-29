package com.salamhack.data.source.remote.dto

data class BalanceDto(
    val currentBalance: Double,
    val currency: String,
    val incomeThisMonth: Double,
    val expensesThisMonth: Double
)