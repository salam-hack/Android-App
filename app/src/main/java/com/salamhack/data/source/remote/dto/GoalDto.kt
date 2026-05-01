package com.salamhack.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class GoalDto(
    @SerializedName("title") val title: String?,
    @SerializedName("isActive") val isActive: Boolean?,
    @SerializedName("progress") val progress: Double?,
    @SerializedName("savedAmount") val savedAmount: Double?,
    @SerializedName("targetAmount") val targetAmount: Double?,
    @SerializedName("categoryId") val categoryId: String?,
    @SerializedName("estimatedDate") val estimatedDate: String?,
    @SerializedName("message") val message: String?
)