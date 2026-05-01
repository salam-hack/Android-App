package com.salamhack.data.source.remote.chatBot.mapper

import com.salamhack.data.source.remote.chatBot.dto.AssistantMessageDto
import com.salamhack.data.source.remote.chatBot.dto.ChatTurnDto
import com.salamhack.data.source.remote.chatBot.dto.ConversationDto
import com.salamhack.domain.entity.ConversationEntity
import com.salamhack.domain.entity.MessageEntity
import java.util.UUID

fun ConversationDto.toDomain() = ConversationEntity(
    id = id.orEmpty(),
    title = title.orEmpty(),
    createdAt = createdAt.orEmpty()
)

fun AssistantMessageDto.toDomain() = MessageEntity(
    id = id.orEmpty(),
    conversationId = conversationId.orEmpty(),
    role = role.orEmpty(),
    content = content.orEmpty(),
    status = status.orEmpty(),
    createdAt = createdAt.orEmpty()
)

fun ChatTurnDto.toDomainMessages(conversationId: String): List<MessageEntity> {
    val messages = mutableListOf<MessageEntity>()

    if (!user.isNullOrBlank()) {
        messages.add(
            MessageEntity(
                id = UUID.randomUUID().toString(),
                conversationId = conversationId,
                role = "user",
                content = user,
                status = "completed",
                createdAt = ""
            )
        )
    }

    if (!assistant.isNullOrBlank()) {
        messages.add(
            MessageEntity(
                id = UUID.randomUUID().toString(),
                conversationId = conversationId,
                role = "assistant",
                content = assistant,
                status = "completed",
                createdAt = ""
            )
        )
    }

    return messages
}