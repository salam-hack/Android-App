package com.salamhack.data.source.remote.chatBot.dto

import com.google.gson.annotations.SerializedName

data class CreateChatResponseDto(
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val data: ConversationDto?
)