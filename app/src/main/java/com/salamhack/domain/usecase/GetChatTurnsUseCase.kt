package com.salamhack.domain.usecase

import com.salamhack.domain.entity.MessageEntity
import com.salamhack.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow

class GetChatTurnsUseCase(
    private val repository: ChatRepository
) {
    operator fun invoke(userId: String, conversationId: String): Flow<Result<List<MessageEntity>>> {
        return repository.getChatTurns(userId, conversationId)
    }
}