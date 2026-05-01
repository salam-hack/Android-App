package com.salamhack.presentation.screen.chatBotHistory

import com.salamhack.domain.entity.ChatHistoryEntity

data class ChatBotHistoryUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val searchQuery: String = "",
    val allChats: List<ChatHistoryEntity> = emptyList(),
    val displayedChats: List<ChatHistoryEntity> = emptyList()
)
