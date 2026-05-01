package com.salamhack.data.source.remote.chatBot

import com.salamhack.data.source.remote.chatBot.api.ChatApiService
import com.salamhack.data.source.remote.chatBot.dto.*

interface ChatRemoteDataSource {
    suspend fun createConversation(userId: String, title: String? = null): CreateChatResponseDto
    suspend fun sendMessage(userId: String, conversationId: String, message: String): SendMessageResponseDto
    suspend fun getChatHistory(userId: String): ChatListResponseDto
    suspend fun getChatTurns(userId: String, conversationId: String, limit: Int? = 50): GetChatTurnsResponseDto
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

    override suspend fun getChatHistory(userId: String): ChatListResponseDto {
        return api.getChatHistory(ChatListRequestDto(userId))
    }

    override suspend fun getChatTurns(userId: String, conversationId: String, limit: Int?): GetChatTurnsResponseDto {
        return api.getChatTurns(conversationId, GetChatTurnsRequestDto(userId, limit))
    }
}