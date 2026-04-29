package com.salamhack.domain.usecase

import com.salamhack.domain.entity.ParsedTransaction
import com.salamhack.domain.repository.TransactionRepository

class ParseTransactionUseCase(
    private val repository: TransactionRepository
) {
    val fakeData = ParsedTransaction(
        title = "قهوة من ستاربكس",
        amount = 75.0,
        isIncome = false,
        categoryId = "EXP_FOOD",
        date = "2026-04-29",
        time = "10:30:00",
        transactionDate = "2026-04-29T10:30:00",
        confidence = 0.87
    )

    suspend operator fun invoke(text: String): ParsedTransaction {
        return fakeData
    }

//    suspend operator fun invoke(text: String): ParsedTransaction {
//        return repository.parseTransaction(text)
//    }
}