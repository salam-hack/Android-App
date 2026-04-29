package com.salamhack.data.source.remote.dto

data class ParseAiResponseDto(
    val success: Boolean,
    val data: ParsedTransactionDto
)

data class ParsedTransactionDto(
    val title: String,
    val amount: Double,
    val type: String,
    val categoryId: String,
    val date: String,
    val time: String,
    val transactionDate: String,
    val confidence: Double
)