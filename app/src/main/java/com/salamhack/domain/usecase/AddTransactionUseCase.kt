package com.salamhack.domain.usecase

import com.salamhack.domain.entity.TransactionEntity
import com.salamhack.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow

class AddTransactionUseCase(
    private val repository: TransactionRepository
) {
    operator fun invoke(
        userId: String,
        title: String,
        amount: String,
        type: String,
        categoryId: String
    ): Flow<Result<TransactionEntity>> {
        return repository.addManualTransaction(userId, title, amount, type, categoryId)
    }
}