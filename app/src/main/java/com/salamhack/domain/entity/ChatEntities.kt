package com.salamhack.domain.entity

data class ConversationEntity(
    val id: String,
    val title: String,
    val createdAt: String
)

data class MessageEntity(
    val id: String,
    val conversationId: String,
    val role: String,
    val content: String,
    val status: String,
    val createdAt: String
)