package com.salamhack.domain.entity

data class Transaction(
    val id: String,
    val title: String,
    val amount: Double,
    val isIncome: Boolean,
    val date: String,
    val icon: String
)
