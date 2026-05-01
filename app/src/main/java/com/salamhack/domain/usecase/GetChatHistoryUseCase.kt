package com.salamhack.domain.usecase

import com.salamhack.domain.entity.ChatHistoryEntity
import com.salamhack.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow

class GetChatHistoryUseCase(
    private val repository: ChatRepository
) {
    operator fun invoke(userId: String): Flow<Result<List<ChatHistoryEntity>>> {
        return repository.getChatHistory(userId)
    }
}