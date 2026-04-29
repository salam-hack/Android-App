package com.salamhack.data.source.remote.transaction

import com.salamhack.data.source.remote.dto.ParseRequestDto
import com.salamhack.data.source.remote.dto.ParsedTransactionDto
import com.salamhack.data.source.remote.transaction.api.TransactionApiService

interface TransactionRemoteDataSource {
    suspend fun parseTransaction(text: String): ParsedTransactionDto
}

class TransactionRemoteDataSourceImpl(
    private val api: TransactionApiService
) : TransactionRemoteDataSource {

    override suspend fun parseTransaction(text: String): ParsedTransactionDto {
        val response = api.parseTransaction(ParseRequestDto(text))

        if (!response.success) {
            throw Exception("Parsing failed")
        }

        return response.data
    }
}