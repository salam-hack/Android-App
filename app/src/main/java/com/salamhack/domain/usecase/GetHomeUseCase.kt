package com.salamhack.domain.usecase

import com.salamhack.domain.entity.Balance
import com.salamhack.domain.entity.Goal
import com.salamhack.domain.entity.HomeEntity
import com.salamhack.domain.entity.SmartAnalysis
import com.salamhack.domain.entity.Transaction
import com.salamhack.domain.entity.User
import com.salamhack.domain.repository.HomeRepository

class GetHomeUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(): HomeEntity {
        return repository.getHome()
    }
}