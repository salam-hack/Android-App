package com.salamhack.domain.usecase

import com.salamhack.domain.entity.ConversationEntity
import com.salamhack.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow

class CreateConversationUseCase(private val repository: ChatRepository) {
    operator fun invoke(userId: String, title: String? = null): Flow<Result<ConversationEntity>> {
        return repository.createConversation(userId, title)
    }
}