package com.salamhack.data.remote.dto

data class TransactionDto(
    val id: String,
    val title: String,
    val amount: Double,
    val type: String,
    val category: String,
    val date: String,
    val icon: String
)