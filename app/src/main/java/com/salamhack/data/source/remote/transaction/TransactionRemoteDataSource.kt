package com.salamhack.data.source.remote.transaction

import com.salamhack.data.source.remote.transaction.api.TransactionApiService
import com.salamhack.data.source.remote.transaction.dto.AddTransactionRequestDto
import com.salamhack.data.source.remote.transaction.dto.AddTransactionResponseDto
import com.salamhack.data.source.remote.transaction.dto.ParseTransactionAiRequestDto
import com.salamhack.data.source.remote.transaction.dto.ParseTransactionAiResponseDto

interface TransactionRemoteDataSource {
    suspend fun addManualTransaction(request: AddTransactionRequestDto): AddTransactionResponseDto
    suspend fun parseTransactionAi(request: ParseTransactionAiRequestDto): ParseTransactionAiResponseDto
}

class TransactionRemoteDataSourceImpl(
    private val api: TransactionApiService
) : TransactionRemoteDataSource {

    override suspend fun addManualTransaction(request: AddTransactionRequestDto): AddTransactionResponseDto {
        return api.addManualTransaction(request)
    }

    override suspend fun parseTransactionAi(request: ParseTransactionAiRequestDto): ParseTransactionAiResponseDto {
        return api.parseTransactionAi(request)
    }
}