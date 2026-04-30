package com.salamhack.data.source.remote.chatBot

import com.salamhack.data.source.remote.chatBot.api.ChatApiService
import com.salamhack.data.source.remote.chatBot.dto.CreateChatRequestDto
import com.salamhack.data.source.remote.chatBot.dto.CreateChatResponseDto
import com.salamhack.data.source.remote.chatBot.dto.SendMessageRequestDto
import com.salamhack.data.source.remote.chatBot.dto.SendMessageResponseDto

interface ChatRemoteDataSource {
    suspend fun createConversation(userId: String, title: String? = null): CreateChatResponseDto
    suspend fun sendMessage(userId: String, conversationId: String, message: String): SendMessageResponseDto
}

class ChatRemoteDataSourceImpl(
    private val api: ChatApiService
) : ChatRemoteDataSource {

    override suspend fun createConversation(userId: String, title: String?): CreateChatResponseDto {
        return api.createConversation(CreateChatRequestDto(userId, title))
    }

    override suspend fun sendMessage(userId: String, conversationId: String, message: String): SendMessageResponseDto {
        return api.sendMessage(SendMessageRequestDto(userId, conversationId, message))
    }
}