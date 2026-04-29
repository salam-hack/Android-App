package com.salamhack.data.source.remote.transaction.api

import com.salamhack.data.source.remote.dto.ParseAiResponseDto
import com.salamhack.data.source.remote.dto.ParseRequestDto
import retrofit2.http.Body
import retrofit2.http.POST

interface TransactionApiService {

    @POST("transactions/parse-ai")
    suspend fun parseTransaction(
        @Body request: ParseRequestDto
    ): ParseAiResponseDto
}