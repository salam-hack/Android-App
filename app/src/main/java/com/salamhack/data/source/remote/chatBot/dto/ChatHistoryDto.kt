package com.salamhack.data.source.remote.chatBot.dto

import com.google.gson.annotations.SerializedName

data class ChatListRequestDto(
    @SerializedName("userId") val userId: String
)

data class ChatListResponseDto(
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val data: List<ChatHistoryItemDto>?
)

data class ChatHistoryItemDto(
    @SerializedName("id") val id: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("summary") val summary: String?,
    @SerializedName("createdAt") val createdAt: String?,
    @SerializedName("lastMessageAt") val lastMessageAt: String?
)