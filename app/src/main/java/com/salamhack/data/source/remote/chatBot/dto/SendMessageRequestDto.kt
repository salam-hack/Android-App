package com.salamhack.data.source.remote.chatBot.dto

import com.google.gson.annotations.SerializedName


data class SendMessageRequestDto(
    @SerializedName("userId") val userId: String,
    @SerializedName("conversationId") val conversationId: String,
    @SerializedName("message") val message: String
)