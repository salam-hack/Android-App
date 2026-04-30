package com.salamhack.presentation.screen.chatBot

interface ChatBotInteractionListener {
    fun onClickBack()
    fun onClickHistory()
    fun onClickSend(message: String)
    fun onClickVoice()
    fun onChatTextFieldChange(text: String)
}