package com.salamhack.domain.repository

import com.salamhack.domain.entity.ConversationEntity
import com.salamhack.domain.entity.MessageEntity
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    fun createConversation(userId: String, title: String? = null): Flow<Result<ConversationEntity>>
    fun sendMessage(userId: String, conversationId: String, message: String): Flow<Result<MessageEntity>>
}