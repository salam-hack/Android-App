package com.salamhack.data.source.remote.chatBot.dto

import com.google.gson.annotations.SerializedName

data class GetChatTurnsRequestDto(
    @SerializedName("userId") val userId: String,
    @SerializedName("limit") val limit: Int? = 50
)

data class GetChatTurnsResponseDto(
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val data: List<ChatTurnDto>?
)

data class ChatTurnDto(
    @SerializedName("user") val user: String?,
    @SerializedName("assistant") val assistant: String?
)
