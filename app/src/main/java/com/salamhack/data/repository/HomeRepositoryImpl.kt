package com.salamhack.data.repository

import com.salamhack.data.mapper.toDomain
import com.salamhack.data.source.remote.home.HomeRemoteDataSource
import com.salamhack.domain.entity.HomeEntity
import com.salamhack.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepositoryImpl(
    private val remote: HomeRemoteDataSource
) : HomeRepository {

    override fun getHome(userId: String): Flow<Result<HomeEntity>> = flow {
        try {
            val response = remote.getHome(userId)

            if (response.success && response.data != null) {
                emit(Result.success(response.toDomain()))
            } else {
                emit(Result.failure(Exception("فشل في تحميل بيانات الصفحة الرئيسية")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}