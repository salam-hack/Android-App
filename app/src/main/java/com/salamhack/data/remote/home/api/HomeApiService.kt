package com.salamhack.data.remote.home.api

import com.salamhack.data.remote.home.dto.HomeResponseDto
import retrofit2.http.GET

interface HomeApiService {

    @GET("home")
    suspend fun getHome(): HomeResponseDto
}