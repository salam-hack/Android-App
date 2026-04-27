package com.salamhack.data.remote.home.dto

import com.salamhack.data.remote.dto.BalanceDto
import com.salamhack.data.remote.dto.GoalDto
import com.salamhack.data.remote.dto.SmartAnalysisDto
import com.salamhack.data.remote.dto.TransactionDto
import com.salamhack.data.remote.dto.UserDto

data class HomeResponseDto(
    val user: UserDto,
    val balance: BalanceDto,
    val goals: List<GoalDto>,
    val smartAnalysis: List<SmartAnalysisDto>,
    val transactions: List<TransactionDto>
)