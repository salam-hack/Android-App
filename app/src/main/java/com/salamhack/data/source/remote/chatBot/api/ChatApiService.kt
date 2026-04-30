package com.salamhack.data.source.remote.chatBot.api

import com.salamhack.data.source.remote.chatBot.dto.CreateChatRequestDto
import com.salamhack.data.source.remote.chatBot.dto.CreateChatResponseDto
import com.salamhack.data.source.remote.chatBot.dto.SendMessageRequestDto
import com.salamhack.data.source.remote.chatBot.dto.SendMessageResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatApiService {
    @POST("api/chat/new")
    suspend fun createConversation(@Body request: CreateChatRequestDto): CreateChatResponseDto

    @POST("api/chat/send")
    suspend fun sendMessage(@Body request: SendMessageRequestDto): SendMessageResponseDto
}