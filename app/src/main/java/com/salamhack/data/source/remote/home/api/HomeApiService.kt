package com.salamhack.data.source.remote.home.api

import com.salamhack.data.source.remote.home.dto.HomeResponseDto
import retrofit2.http.GET

interface HomeApiService {

    @GET("home")
    suspend fun getHome(): HomeResponseDto
}