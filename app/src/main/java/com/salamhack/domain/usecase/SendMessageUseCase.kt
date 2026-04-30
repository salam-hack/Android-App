package com.salamhack.domain.usecase

import com.salamhack.domain.entity.MessageEntity
import com.salamhack.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow

class SendMessageUseCase(private val repository: ChatRepository) {
    operator fun invoke(userId: String, conversationId: String, message: String): Flow<Result<MessageEntity>> {
        return repository.sendMessage(userId, conversationId, message)
    }
}