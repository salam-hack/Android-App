package com.salamhack.presentation.screen.chatBot


data class ChatBotUiState(
    val conversationId: String? = null,
    val isLoadingHistory: Boolean = false,
    val error: String? = null,
    val isAssistantOnline: Boolean = true,
    val messages: List<ChatMessage> = emptyList(),
    val suggestedPrompts: List<SuggestedPrompt> = emptyList(),
    val isAssistantTyping: Boolean = false,
    val currentInputText: String = "",
    val isRecordingVoice: Boolean = false,
)

data class ChatMessage(
    val id: String,
    val text: String,
    val sender: MessageSender,
    val time: String
)

enum class MessageSender { USER, ASSISTANT }

data class SuggestedPrompt(val id: String, val text: String, val iconId: Int? = null)
