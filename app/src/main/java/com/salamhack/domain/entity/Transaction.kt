package com.salamhack.domain.entity

data class TransactionEntity(
    val id: String,
    val title: String,
    val amount: Double,
    val type: String,
    val categoryId: String,
    val date: String
)
