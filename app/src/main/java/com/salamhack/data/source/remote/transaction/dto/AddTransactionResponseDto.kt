package com.salamhack.data.source.remote.transaction.dto

import com.google.gson.annotations.SerializedName
import com.salamhack.data.source.remote.chatBot.dto.AssistantMessageDto
import com.salamhack.data.source.remote.dto.TransactionDto

data class AddTransactionResponseDto(
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val data: TransactionDto?,
    @SerializedName("assistantMessage") val assistantMessage: AssistantMessageDto?
)