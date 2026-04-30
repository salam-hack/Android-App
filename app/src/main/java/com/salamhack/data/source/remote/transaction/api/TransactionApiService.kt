package com.salamhack.data.source.remote.transaction.api

import com.salamhack.data.source.remote.transaction.dto.AddTransactionRequestDto
import com.salamhack.data.source.remote.transaction.dto.AddTransactionResponseDto
import retrofit2.http.Body
import retrofit2.http.POST


interface TransactionApiService {
    @POST("api/transactions/add-manual")
    suspend fun addManualTransaction(@Body request: AddTransactionRequestDto): AddTransactionResponseDto
}