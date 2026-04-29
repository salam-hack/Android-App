package com.salamhack.domain.entity

data class ParsedTransaction(
    val title: String,
    val amount: Double,
    val isIncome: Boolean,
    val categoryId: String,
    val date: String,
    val time: String,
    val transactionDate: String,
    val confidence: Double
)