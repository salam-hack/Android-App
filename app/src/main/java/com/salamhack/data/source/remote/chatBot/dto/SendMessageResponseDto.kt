package com.salamhack.data.source.remote.chatBot.dto

import com.google.gson.annotations.SerializedName

data class SendMessageResponseDto(
    @SerializedName("assistantMessage") val assistantMessage: AssistantMessageDto?
)