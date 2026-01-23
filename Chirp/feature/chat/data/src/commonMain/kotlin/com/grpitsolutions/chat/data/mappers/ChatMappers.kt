package com.grpitsolutions.chat.data.mappers

import com.grpitsolutions.chat.data.dto.response.ChatDTO
import com.grpitsolutions.chat.domain.models.Chat
import kotlin.time.Instant

fun ChatDTO.toDomain(): Chat {
    return Chat(
        id = id,
        participants = participants.map { it.toDomain() },
        lastActivityAt = Instant.parse(lastActivityAt),
        lastMessage = lastMessage?.toDomain(),
    )
}