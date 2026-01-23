package com.grpitsolutions.chat.data.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class CreateChatRequestDTO(
    val otherUserIds: List<String>
)