package com.salamhack.presentation.screen.chatBotHistory

interface ChatBotHistoryInteractionListener {
    fun onClickBack()
    fun onClickChat(chatId: String)
    fun onSearchChat(query: String)
    fun onClickNewChat()
}