package com.salamhack.domain.entity

data class ChatHistoryEntity(
    val id: String,
    val title: String,
    val summary: String,
    val createdAt: String,
    val lastMessageAt: String,
    val displayTime: String
)