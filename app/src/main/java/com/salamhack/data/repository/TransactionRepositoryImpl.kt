package com.salamhack.data.repository

import com.salamhack.data.mapper.toDomain
import com.salamhack.data.source.remote.transaction.TransactionRemoteDataSource
import com.salamhack.data.source.remote.transaction.dto.AddTransactionRequestDto
import com.salamhack.data.source.remote.transaction.dto.ParseTransactionAiRequestDto
import com.salamhack.data.source.remote.transaction.mapper.toDomain
import com.salamhack.domain.entity.ParsedTransaction
import com.salamhack.domain.entity.TransactionEntity
import com.salamhack.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TransactionRepositoryImpl(
    private val remote: TransactionRemoteDataSource
) : TransactionRepository {

    override fun addManualTransaction(
        userId: String,
        title: String,
        amount: String,
        type: String,
        categoryId: String
    ): Flow<Result<TransactionEntity>> = flow {
        try {
            val request = AddTransactionRequestDto(
                userId = userId,
                title = title,
                amount = amount,
                type = type,
                categoryId = categoryId
            )

            val response = remote.addManualTransaction(request)

            if (response.success && response.data != null) {
                emit(Result.success(response.data.toDomain()))
            } else {
                emit(Result.failure(Exception("فشل في إضافة المعاملة")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    override fun parseTransactionAi(userId: String, message: String): Flow<Result<ParsedTransaction>> = flow {
        try {
            val request = ParseTransactionAiRequestDto(userId, message)
            val response = remote.parseTransactionAi(request)

            if (response.success && response.data != null) {
                emit(Result.success(response.data.toDomain()))
            } else {
                emit(Result.failure(Exception("فشل في تحليل النص المدخل")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}