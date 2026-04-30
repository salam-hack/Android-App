package com.salamhack.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class BalanceDto(
    @SerializedName("currentBalance") val currentBalance: Double?,
    @SerializedName("incomeThisMonth") val incomeThisMonth: Double?,
    @SerializedName("expensesThisMonth") val expensesThisMonth: Double?
)