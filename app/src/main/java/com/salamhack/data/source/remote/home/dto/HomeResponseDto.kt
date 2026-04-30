package com.salamhack.data.source.remote.home.dto

import com.google.gson.annotations.SerializedName
import com.salamhack.data.source.remote.dto.BalanceDto
import com.salamhack.data.source.remote.dto.GoalDto
import com.salamhack.data.source.remote.dto.SmartAnalysisDto
import com.salamhack.data.source.remote.dto.TransactionDto
import com.salamhack.data.source.remote.dto.UserDto

data class HomeResponseDto(
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val data: HomeDataDto?
)

data class HomeDataDto(
    @SerializedName("user") val user: UserDto?,
    @SerializedName("balance") val balance: BalanceDto?,
    @SerializedName("goals") val goals: List<GoalDto>?,
    @SerializedName("smartAnalysis") val smartAnalysis: List<SmartAnalysisDto>?,
    @SerializedName("transactions") val transactions: List<TransactionDto>?
)