package com.salamhack.data.repository

import com.salamhack.data.mapper.toEntity
import com.salamhack.data.remote.home.HomeRemoteDataSource
import com.salamhack.domain.entity.HomeEntity
import com.salamhack.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val remote: HomeRemoteDataSource
) : HomeRepository {

    override suspend fun getHome(): HomeEntity {
        return remote.getHome().toEntity()
    }
}