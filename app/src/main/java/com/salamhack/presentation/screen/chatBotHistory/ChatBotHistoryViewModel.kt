package com.salamhack.presentation.screen.chatBotHistory

import androidx.navigation.compose.DialogNavigator
import com.salamhack.presentation.navigation.Destinations
import com.salamhack.presentation.shared.utils.BaseViewModel

class ChatBotHistoryViewModel(): BaseViewModel<ChatBotHistoryUiState>(ChatBotHistoryUiState()),
    ChatBotHistoryInteractionListener {

    override fun onClickBack() {
        navigateUp()
    }

    override fun onClickChat() {
        TODO("Not yet implemented")
    }

    override fun onSearchChat() {
        TODO("Not yet implemented")
    }

    override fun onClickNewChat() {
        navigate(Destinations.ChatBot)
    }
}