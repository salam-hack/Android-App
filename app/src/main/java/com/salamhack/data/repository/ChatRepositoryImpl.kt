package com.salamhack.data.repository

import com.salamhack.data.source.remote.chatBot.ChatRemoteDataSource
import com.salamhack.data.source.remote.chatBot.mapper.toDomain
import com.salamhack.domain.entity.ChatHistoryEntity
import com.salamhack.domain.entity.ConversationEntity
import com.salamhack.domain.entity.MessageEntity
import com.salamhack.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ChatRepositoryImpl(
    private val remote: ChatRemoteDataSource
) : ChatRepository {

    override fun createConversation(userId: String, title: String?): Flow<Result<ConversationEntity>> = flow {
        try {
            val response = remote.createConversation(userId, title)
            if (response.success && response.data != null) {
                emit(Result.success(response.data.toDomain()))
            } else {
                emit(Result.failure(Exception("فشل في إنشاء المحادثة")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    override fun sendMessage(userId: String, conversationId: String, message: String): Flow<Result<MessageEntity>> = flow {
        try {
            val response = remote.sendMessage(userId, conversationId, message)
            if (response.assistantMessage != null) {
                emit(Result.success(response.assistantMessage.toDomain()))
            } else {
                emit(Result.failure(Exception("فشل في استلام الرد")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    override fun getChatHistory(userId: String): Flow<Result<List<ChatHistoryEntity>>> = flow {
        try {
            val response = remote.getChatHistory(userId)
            if (response.success && response.data != null) {
                val mappedList = response.data.map { it.toDomain() }
                emit(Result.success(mappedList))
            } else {
                emit(Result.failure(Exception("فشل في تحميل السجل")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}