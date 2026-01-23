package com.grpitsolutions.chat.data.mappers

import com.grpitsolutions.chat.data.dto.response.ChatMessageDTO
import com.grpitsolutions.chat.domain.models.ChatMessage
import kotlin.time.Instant

fun ChatMessageDTO.toDomain(): ChatMessage {
    return ChatMessage(
        id = id,
        chatId = chatId,
        content = content,
        senderId = senderId,
        createAt = Instant.parse(createdAt)
    )
}