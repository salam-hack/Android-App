package com.salamhack.data.mapper

import com.salamhack.data.source.remote.dto.BalanceDto
import com.salamhack.data.source.remote.dto.GoalDto
import com.salamhack.data.source.remote.dto.ParsedTransactionDto
import com.salamhack.data.source.remote.home.dto.HomeResponseDto
import com.salamhack.data.source.remote.dto.SmartAnalysisDto
import com.salamhack.data.source.remote.dto.TransactionDto
import com.salamhack.data.source.remote.dto.UserDto
import com.salamhack.domain.entity.BalanceEntity
import com.salamhack.domain.entity.GoalEntity
import com.salamhack.domain.entity.HomeEntity
import com.salamhack.domain.entity.ParsedTransaction
import com.salamhack.domain.entity.SmartAnalysisEntity
import com.salamhack.domain.entity.TransactionEntity
import com.salamhack.domain.entity.UserEntity

fun HomeResponseDto.toDomain(): HomeEntity {
    return HomeEntity(
        user = this.data?.user?.toDomain() ?: UserEntity(),
        balance = this.data?.balance?.toDomain() ?: BalanceEntity(),
        goals = this.data?.goals?.map { it.toDomain() } ?: emptyList(),
        smartAnalysis = this.data?.smartAnalysis?.map { it.toDomain() } ?: emptyList(),
        transactions = this.data?.transactions?.map { it.toDomain() } ?: emptyList()
    )
}

fun UserDto.toDomain() = UserEntity(
    name = name.orEmpty(),
    profileImage = profileImage,
    hasNotification = hasNotification ?: false
)

fun BalanceDto.toDomain() = BalanceEntity(
    currentBalance = currentBalance ?: 0.0,
    incomeThisMonth = incomeThisMonth ?: 0.0,
    expensesThisMonth = expensesThisMonth ?: 0.0
)

fun GoalDto.toDomain() = GoalEntity(
    title = title.orEmpty(),
    isActive = isActive ?: false,
    progress = progress ?: 0.0,
    savedAmount = savedAmount ?: 0.0,
    targetAmount = targetAmount ?: 0.0,
    message = message.orEmpty()
)

fun SmartAnalysisDto.toDomain() = SmartAnalysisEntity(
    title = title.orEmpty(),
    description = description.orEmpty(),
    type = type.orEmpty()
)

fun TransactionDto.toDomain() = TransactionEntity(
    id = id.orEmpty(),
    title = title.orEmpty(),
    amount = amount ?: 0.0,
    type = type.orEmpty(),
    categoryId = categoryId.orEmpty(),
    date = date.orEmpty()
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