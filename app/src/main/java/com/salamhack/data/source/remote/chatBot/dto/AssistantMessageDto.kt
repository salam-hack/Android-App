package com.salamhack.data.source.remote.chatBot.dto

import com.google.gson.annotations.SerializedName

data class AssistantMessageDto(
    @SerializedName("id") val id: String?,
    @SerializedName("conversationId") val conversationId: String?,
    @SerializedName("userId") val userId: String?,
    @SerializedName("role") val role: String?,
    @SerializedName("content") val content: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("createdAt") val createdAt: String?
)