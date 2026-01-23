package com.grpitsolutions.chat.data.dto.response

import kotlinx.serialization.Serializable
import org.koin.core.scope.ScopeID

@Serializable
data class ChatMessageDTO(
    val id: String,
    val chatId: String,
    val content: String,
    val createdAt: String,
    val senderId: String
)
