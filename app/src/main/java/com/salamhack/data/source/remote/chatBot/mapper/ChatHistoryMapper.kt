package com.salamhack.data.source.remote.chatBot.mapper


import com.salamhack.data.source.remote.chatBot.dto.ChatHistoryItemDto
import com.salamhack.domain.entity.ChatHistoryEntity
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

fun ChatHistoryItemDto.toDomain(): ChatHistoryEntity {
    val dateString = lastMessageAt ?: createdAt ?: ""
    val formattedTime = formatToTime(dateString)

    return ChatHistoryEntity(
        id = id.orEmpty(),
        title = title ?: "محادثة جديدة",
        summary = summary ?: "لا يوجد ملخص",
        createdAt = createdAt.orEmpty(),
        lastMessageAt = lastMessageAt.orEmpty(),
        displayTime = formattedTime
    )
}

private fun formatToTime(isoString: String): String {
    if (isoString.isBlank()) return ""
    return try {
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
        parser.timeZone = TimeZone.getTimeZone("UTC")
        val date = parser.parse(isoString)
        val formatter = SimpleDateFormat("hh:mm a", Locale("ar"))
        date?.let { formatter.format(it) } ?: ""
    } catch (e: Exception) {
        ""
    }
}