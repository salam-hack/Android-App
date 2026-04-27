package com.salamhack.domain.repository


import com.salamhack.domain.entity.HomeEntity

interface HomeRepository {
    suspend fun getHome(): HomeEntity
}