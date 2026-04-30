package com.salamhack.domain.repository

import com.salamhack.domain.entity.HomeEntity
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getHome(userId: String): Flow<Result<HomeEntity>>
}