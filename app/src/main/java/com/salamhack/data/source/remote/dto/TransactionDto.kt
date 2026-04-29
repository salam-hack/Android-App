package com.salamhack.data.source.remote.dto

data class TransactionDto(
    val id: String,
    val title: String,
    val amount: Double,
    val type: String,
    val category: String,
    val categoryId: String,
    val date: String,
    val icon: String
)