package com.salamhack.data.source.remote.home.api

import com.salamhack.data.source.remote.home.dto.HomeRequestDto
import com.salamhack.data.source.remote.home.dto.HomeResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface HomeApiService {
    @POST("api/home")
    suspend fun getHome(@Body request: HomeRequestDto): HomeResponseDto
}