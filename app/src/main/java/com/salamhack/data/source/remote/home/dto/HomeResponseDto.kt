package com.salamhack.data.source.remote.home.dto

import com.salamhack.data.source.remote.dto.BalanceDto
import com.salamhack.data.source.remote.dto.GoalDto
import com.salamhack.data.source.remote.dto.SmartAnalysisDto
import com.salamhack.data.source.remote.dto.TransactionDto
import com.salamhack.data.source.remote.dto.UserDto

data class HomeResponseDto(
    val user: UserDto,
    val balance: BalanceDto,
    val goals: List<GoalDto>,
    val smartAnalysis: List<SmartAnalysisDto>,
    val transactions: List<TransactionDto>
)