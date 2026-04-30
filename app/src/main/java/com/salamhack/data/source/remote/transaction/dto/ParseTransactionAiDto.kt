package com.salamhack.data.source.remote.transaction.dto

import com.google.gson.annotations.SerializedName

data class ParseTransactionAiRequestDto(
    @SerializedName("userId") val userId: String,
    @SerializedName("message") val message: String
)

data class ParseTransactionAiResponseDto(
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val data: ParsedTransactionDataDto?
)

data class ParsedTransactionDataDto(
    @SerializedName("amount") val amount: Double?,
    @SerializedName("Product") val product: String?,
    @SerializedName("merchant") val merchant: String?,
    @SerializedName("category") val category: String?,
    @SerializedName("date") val date: String?,
    @SerializedName("categoryId") val categoryId: String?
)