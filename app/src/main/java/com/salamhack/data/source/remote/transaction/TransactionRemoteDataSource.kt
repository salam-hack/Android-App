package com.salamhack.data.source.remote.transaction

import com.salamhack.data.source.remote.transaction.api.TransactionApiService
import com.salamhack.data.source.remote.transaction.dto.AddTransactionRequestDto
import com.salamhack.data.source.remote.transaction.dto.AddTransactionResponseDto

interface TransactionRemoteDataSource {
    suspend fun addManualTransaction(request: AddTransactionRequestDto): AddTransactionResponseDto
}

class TransactionRemoteDataSourceImpl(
    private val api: TransactionApiService
) : TransactionRemoteDataSource {

    override suspend fun addManualTransaction(request: AddTransactionRequestDto): AddTransactionResponseDto {
        return api.addManualTransaction(request)
    }
}