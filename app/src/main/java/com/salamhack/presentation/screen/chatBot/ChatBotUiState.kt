package com.salamhack.presentation.screen.chatBot

data class ChatBotUiState(
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
    val time: String,
//    val actionButton: ChatAction? = null
)

enum class MessageSender {
    USER,
    ASSISTANT
}

data class SuggestedPrompt(
    val id: String,
    val text: String,
    val iconId: Int? = null
)

//data class ChatAction(
//    val title: String,
//    val actionType: ActionType
//)
//
//enum class ActionType {
//    EDIT_BUDGET,
//    ANALYZE_EXPENSES,
//}
