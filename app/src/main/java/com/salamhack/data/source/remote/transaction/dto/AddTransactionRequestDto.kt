package com.salamhack.data.source.remote.transaction.dto

import com.google.gson.annotations.SerializedName

data class AddTransactionRequestDto(
    @SerializedName("userId") val userId: String,
    @SerializedName("title") val title: String,
    @SerializedName("amount") val amount: String,
    @SerializedName("type") val type: String,
    @SerializedName("categoryId") val categoryId: String
)