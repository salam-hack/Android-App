package com.salamhack.domain.entity

data class HomeEntity(
    val user: UserEntity,
    val balance: BalanceEntity,
    val goals: List<GoalEntity>,
    val smartAnalysis: List<SmartAnalysisEntity>,
    val transactions: List<TransactionEntity>
)