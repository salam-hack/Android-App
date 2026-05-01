package com.salamhack.data.source.remote.chatBot.api

import com.salamhack.data.source.remote.chatBot.dto.*
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface ChatApiService {
    @POST("api/chat/new")
    suspend fun createConversation(@Body request: CreateChatRequestDto): CreateChatResponseDto

    @POST("api/chat/send")
    suspend fun sendMessage(@Body request: SendMessageRequestDto): SendMessageResponseDto

    @POST("api/chat/list")
    suspend fun getChatHistory(@Body request: ChatListRequestDto): ChatListResponseDto

    @POST("api/chat/{conversationId}/turns")
    suspend fun getChatTurns(
        @Path("conversationId") conversationId: String,
        @Body request: GetChatTurnsRequestDto
    ): GetChatTurnsResponseDto
}