package com.salamhack.data.source.remote.chatBot.dto

import com.google.gson.annotations.SerializedName

data class ConversationDto(
    @SerializedName("id") val id: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("createdAt") val createdAt: String?
)