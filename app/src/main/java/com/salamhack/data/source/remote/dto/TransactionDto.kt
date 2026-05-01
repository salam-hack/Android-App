package com.salamhack.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class TransactionDto(
    @SerializedName("id") val id: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("amount") val amount: Double?,
    @SerializedName("type") val type: String?,
    @SerializedName("categoryId") val categoryId: String?,
    @SerializedName("date") val date: String?
)