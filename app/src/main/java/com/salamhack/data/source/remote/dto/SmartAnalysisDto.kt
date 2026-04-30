package com.salamhack.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class SmartAnalysisDto(
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("type") val type: String?
)