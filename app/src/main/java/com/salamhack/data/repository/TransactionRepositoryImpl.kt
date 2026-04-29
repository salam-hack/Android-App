package com.salamhack.data.repository

import com.salamhack.data.mapper.toEntity
import com.salamhack.data.source.remote.transaction.TransactionRemoteDataSource
import com.salamhack.domain.entity.ParsedTransaction
import com.salamhack.domain.repository.TransactionRepository

class TransactionRepositoryImpl(
    private val remote: TransactionRemoteDataSource
) : TransactionRepository {

    override suspend fun parseTransaction(text: String): ParsedTransaction {
        return remote.parseTransaction(text).toEntity()
    }
}