package com.salamhack.domain.usecase

import com.salamhack.domain.entity.ParsedTransaction
import com.salamhack.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow

class ParseTransactionUseCase(
    private val repository: TransactionRepository
) {
    operator fun invoke(userId: String, message: String): Flow<Result<ParsedTransaction>> {
        return repository.parseTransactionAi(userId, message)
    }
}