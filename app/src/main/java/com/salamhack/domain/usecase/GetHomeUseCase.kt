package com.salamhack.domain.usecase

import com.salamhack.domain.entity.HomeEntity
import com.salamhack.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class GetHomeUseCase(
    private val repository: HomeRepository
) {
    operator fun invoke(userId: String): Flow<Result<HomeEntity>> {
        return repository.getHome(userId)
    }
}