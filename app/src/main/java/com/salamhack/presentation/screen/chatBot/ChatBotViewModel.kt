package com.salamhack.presentation.screen.chatBot

import com.salamhack.presentation.shared.utils.BaseViewModel

class ChatBotViewModel(): BaseViewModel<ChatBotUiState>(ChatBotUiState()),
ChatBotInteractionListener{

    override fun onClickBack() {
        navigateUp()
    }

    override fun onClickHistory() {
        TODO("Not yet implemented")
    }

    override fun onClickSend(message: String) {
        TODO("Not yet implemented")
    }

    override fun onClickVoice() {
        TODO("Not yet implemented")
    }

    override fun onChatTextFieldChange(text: String) {
        updateState(
            newState = screenState.value.copy(
                currentInputText = text
            )
        )
    }
}