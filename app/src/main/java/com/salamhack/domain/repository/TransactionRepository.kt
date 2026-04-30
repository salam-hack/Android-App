package com.salamhack.domain.repository

import com.salamhack.domain.entity.ParsedTransaction
import com.salamhack.domain.entity.TransactionEntity
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {
    fun addManualTransaction(
        userId: String, title: String, amount: String, type: String, categoryId: String
    ): Flow<Result<TransactionEntity>>

    fun parseTransactionAi(userId: String, message: String): Flow<Result<ParsedTransaction>>
}