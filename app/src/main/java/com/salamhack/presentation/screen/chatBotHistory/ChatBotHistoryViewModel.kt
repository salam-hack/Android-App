package com.salamhack.presentation.screen.chatBotHistory

import android.util.Log
import com.salamhack.domain.usecase.GetChatHistoryUseCase
import com.salamhack.presentation.navigation.Destinations
import com.salamhack.presentation.shared.utils.BaseViewModel

class ChatBotHistoryViewModel(
    private val getChatHistoryUseCase: GetChatHistoryUseCase
) : BaseViewModel<ChatBotHistoryUiState>(ChatBotHistoryUiState()),
    ChatBotHistoryInteractionListener {

    private val userId = "550e8400-e29b-41d4-a716-446655440001"

    init {
        loadHistory()
    }

    private fun loadHistory() {
        tryToObserve(
            observe = {
                getChatHistoryUseCase(userId)
            },
            onStart = {
                updateState(screenState.value.copy(isLoading = true, error = null))
            },
            onEach = { result ->
                result?.fold(
                    onSuccess = { chats ->
                        updateState(
                            screenState.value.copy(
                                isLoading = false,
                                allChats = chats,
                                displayedChats = chats
                            )
                        )
                    },
                    onFailure = { error ->
                        updateState(
                            screenState.value.copy(
                                isLoading = false,
                                error = error.message ?: "حدث خطأ أثناء تحميل السجل"
                            )
                        )
                    }
                )
            },
            onError = {
                updateState(screenState.value.copy(isLoading = false, error = it.message))
            }
        )
    }

    override fun onClickBack() {
        navigateUp()
    }

    override fun onClickChat(chatId: String) {
        navigate(Destinations.ChatBot(chatId = chatId))
    }

    override fun onSearchChat(query: String) {
        val currentState = screenState.value
        val filteredList = if (query.isBlank()) {
            currentState.allChats
        } else {
            currentState.allChats.filter {
                it.title.contains(query, ignoreCase = true) ||
                        it.summary.contains(query, ignoreCase = true)
            }
        }

        updateState(
            currentState.copy(
                searchQuery = query,
                displayedChats = filteredList
            )
        )
    }

    override fun onClickNewChat() {
        navigate(Destinations.ChatBot())
    }
}