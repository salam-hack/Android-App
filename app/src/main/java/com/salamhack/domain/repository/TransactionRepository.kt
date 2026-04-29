package com.salamhack.domain.repository

import com.salamhack.domain.entity.ParsedTransaction

interface TransactionRepository {
    suspend fun parseTransaction(text: String): ParsedTransaction
}