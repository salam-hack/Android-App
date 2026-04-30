package com.salamhack.presentation.screen.chatBot

import kotlinx.coroutines.flow.Flow

interface ChatBotInteractionListener {
    fun onClickBack()
    fun onClickHistory()
    fun onClickSend(messageText: String)
    fun onClickVoice()
    fun onChatTextFieldChange(text: String)
}