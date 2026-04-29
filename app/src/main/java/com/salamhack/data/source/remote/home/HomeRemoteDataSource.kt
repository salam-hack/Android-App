package com.salamhack.data.source.remote.home

import com.salamhack.data.source.remote.home.api.HomeApiService
import com.salamhack.data.source.remote.home.dto.HomeResponseDto

interface HomeRemoteDataSource {
    suspend fun getHome(): HomeResponseDto
}

class HomeRemoteDataSourceImpl(
    private val api: HomeApiService
) : HomeRemoteDataSource {

    override suspend fun getHome(): HomeResponseDto {
        return api.getHome()
    }
}