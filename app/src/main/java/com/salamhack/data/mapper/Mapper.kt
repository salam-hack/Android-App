package com.salamhack.data.mapper

import com.salamhack.data.source.remote.dto.BalanceDto
import com.salamhack.data.source.remote.dto.GoalDto
import com.salamhack.data.source.remote.dto.ParsedTransactionDto
import com.salamhack.data.source.remote.home.dto.HomeResponseDto
import com.salamhack.data.source.remote.dto.SmartAnalysisDto
import com.salamhack.data.source.remote.dto.TransactionDto
import com.salamhack.data.source.remote.dto.UserDto
import com.salamhack.domain.entity.Balance
import com.salamhack.domain.entity.Goal
import com.salamhack.domain.entity.HomeEntity
import com.salamhack.domain.entity.ParsedTransaction
import com.salamhack.domain.entity.SmartAnalysis
import com.salamhack.domain.entity.Transaction
import com.salamhack.domain.entity.User

fun HomeResponseDto.toEntity(): HomeEntity {
    return HomeEntity(
        user = user.toEntity(),
        balance = balance.toEntity(),
        goals = goals.map { it.toEntity() },
        smartAnalysis = smartAnalysis.map { it.toEntity() },
        transactions = transactions.map { it.toEntity() }
    )
}

fun UserDto.toEntity() = User(name, profileImage, hasNotification)

fun BalanceDto.toEntity() = Balance(
    currentBalance,
    currency,
    incomeThisMonth,
    expensesThisMonth
)

fun GoalDto.toEntity() = Goal(
    title,
    progress.toFloat(),
    savedAmount,
    targetAmount,
    message
)

fun SmartAnalysisDto.toEntity() = SmartAnalysis(message)

fun TransactionDto.toEntity() = Transaction(
    id,
    title,
    amount,
    type == "income",
    category,
    categoryId,
    date,
    icon
)

fun ParsedTransactionDto.toEntity(): ParsedTransaction {
    return ParsedTransaction(
        title = title,
        amount = amount,
        isIncome = type == "income",
        categoryId = categoryId,
        date = date,
        time = time,
        transactionDate = transactionDate,
        confidence = confidence
    )
}