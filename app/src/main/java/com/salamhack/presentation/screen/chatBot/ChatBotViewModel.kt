package com.salamhack.presentation.screen.chatBot

import androidx.lifecycle.SavedStateHandle
import com.salamhack.domain.usecase.CreateConversationUseCase
import com.salamhack.domain.usecase.GetChatTurnsUseCase
import com.salamhack.domain.usecase.SendMessageUseCase
import com.salamhack.presentation.navigation.Destinations
import com.salamhack.presentation.shared.utils.BaseViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID

class ChatBotViewModel(
    savedStateHandle: SavedStateHandle,
    private val createConversationUseCase: CreateConversationUseCase,
    private val sendMessageUseCase: SendMessageUseCase,
    private val getChatTurnsUseCase: GetChatTurnsUseCase
): BaseViewModel<ChatBotUiState>(ChatBotUiState()),
ChatBotInteractionListener{

    private val userId = "550e8400-e29b-41d4-a716-446655440001"

    init {
        val passedConversationId = savedStateHandle.get<String>("chatId")

        if (!passedConversationId.isNullOrBlank()) {
            updateState(screenState.value.copy(conversationId = passedConversationId))
            loadChatTurns(passedConversationId)
        }
    }

    private fun loadChatTurns(conversationId: String) {
        tryToObserve(
            observe = { getChatTurnsUseCase(userId = userId, conversationId = conversationId) },
            onStart = {
                updateState(screenState.value.copy(error = null))
            },
            onEach = { result ->
                result?.fold(
                    onSuccess = { messageEntities ->
                        val chatMessages = messageEntities.map { entity ->
                            ChatMessage(
                                id = entity.id,
                                text = entity.content,
                                sender = if (entity.role == "user") MessageSender.USER else MessageSender.ASSISTANT,
                                time = getCurrentFormattedTime()
                            )
                        }

                        updateState(
                            screenState.value.copy(
                                messages = chatMessages
                            )
                        )
                    },
                    onFailure = { error ->
                        updateState(
                            screenState.value.copy(
                                error = "فشل تحميل المحادثة: ${error.message}"
                            )
                        )
                    }
                )
            }
        )
    }

    override fun onClickBack() {
        navigateUp()
    }

    override fun onClickHistory() {
        navigate(Destinations.ChatBotHistory)
    }

    override fun onChatTextFieldChange(text: String) {
        updateState(screenState.value.copy(currentInputText = text))
    }

    override fun onClickSend(messageText: String) {
        if (messageText.isBlank()) return

        val userMessage = ChatMessage(
            id = UUID.randomUUID().toString(),
            text = messageText,
            sender = MessageSender.USER,
            time = getCurrentFormattedTime()
        )

        updateState(
            newState = screenState.value.copy(
                messages = screenState.value.messages + userMessage,
                currentInputText = "",
                isAssistantTyping = true,
                error = null
            )
        )

        val currentConversationId = screenState.value.conversationId

        if (currentConversationId == null) {
            tryToObserve(
                observe = { createConversationUseCase(userId = userId) },
                onEach = { result ->
                    result?.fold(
                        onSuccess = { conversation ->
                            updateState(screenState.value.copy(conversationId = conversation.id))

                            sendMessageToApi(conversation.id, messageText)
                        },
                        onFailure = { error ->
                            updateState(
                                screenState.value.copy(
                                    isAssistantTyping = false,
                                    error = "فشل إنشاء المحادثة: ${error.message}"
                                )
                            )
                        }
                    )
                }
            )
        } else {
            sendMessageToApi(currentConversationId, messageText)
        }
    }

    private fun sendMessageToApi(conversationId: String, text: String) {
        tryToObserve(
            observe = { sendMessageUseCase(userId = userId, conversationId = conversationId, message = text) },
            onEach = { result ->
                result?.fold(
                    onSuccess = { messageEntity ->
                        val assistantMessage = ChatMessage(
                            id = messageEntity.id,
                            text = messageEntity.content,
                            sender = MessageSender.ASSISTANT,
                            time = getCurrentFormattedTime()
                        )
                        updateState(
                            screenState.value.copy(
                                messages = screenState.value.messages + assistantMessage,
                                isAssistantTyping = false
                            )
                        )
                    },
                    onFailure = { error ->
                        updateState(
                            screenState.value.copy(
                                isAssistantTyping = false,
                                error = "فشل استلام الرد: ${error.message}"
                            )
                        )
                    }
                )
            }
        )
    }

    override fun onClickVoice() {}

    private fun getCurrentFormattedTime(): String {
        return SimpleDateFormat("hh:mm a", Locale("ar")).format(Date())
    }
}