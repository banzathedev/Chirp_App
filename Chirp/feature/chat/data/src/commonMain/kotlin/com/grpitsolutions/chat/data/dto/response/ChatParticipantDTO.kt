package com.grpitsolutions.chat.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class ChatParticipantDTO(
    val userId: String,
    val username: String,
    val profilePictureUrl: String?
)