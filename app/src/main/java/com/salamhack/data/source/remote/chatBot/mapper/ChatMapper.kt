package com.salamhack.data.source.remote.chatBot.mapper

import com.salamhack.data.source.remote.chatBot.dto.AssistantMessageDto
import com.salamhack.data.source.remote.chatBot.dto.ConversationDto
import com.salamhack.domain.entity.ConversationEntity
import com.salamhack.domain.entity.MessageEntity

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