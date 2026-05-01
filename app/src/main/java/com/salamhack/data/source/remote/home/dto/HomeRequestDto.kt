package com.salamhack.data.source.remote.home.dto

import com.google.gson.annotations.SerializedName

data class HomeRequestDto(
    @SerializedName("userId") val userId: String
)