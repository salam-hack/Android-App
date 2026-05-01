package com.salamhack.data.source.remote.home

import com.salamhack.data.source.remote.home.api.HomeApiService
import com.salamhack.data.source.remote.home.dto.HomeResponseDto
import com.salamhack.data.source.remote.home.dto.HomeRequestDto

interface HomeRemoteDataSource {
    suspend fun getHome(userId: String): HomeResponseDto
}

class HomeRemoteDataSourceImpl(
    private val api: HomeApiService
) : HomeRemoteDataSource {

    override suspend fun getHome(userId: String): HomeResponseDto {
        val request = HomeRequestDto(userId = userId)
        return api.getHome(request)
    }
}