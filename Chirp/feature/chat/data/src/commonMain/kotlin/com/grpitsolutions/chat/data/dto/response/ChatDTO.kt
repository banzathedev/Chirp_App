package com.grpitsolutions.chat.data.dto.response

import com.grpitsolutions.chat.domain.models.ChatMessage
import kotlinx.serialization.Serializable

@Serializable
data class ChatDTO(
    val id: String,
    val participants: List<ChatParticipantDTO>,
    val lastActivityAt: String,
    val lastMessage: ChatMessageDTO?
)
