package com.salamhack.data.source.remote.chatBot.dto

import com.google.gson.annotations.SerializedName

data class CreateChatRequestDto(
    @SerializedName("userId") val userId: String,
    @SerializedName("title") val title: String? = null
)
