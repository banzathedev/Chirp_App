package com.grpitsolutions.chat.data.mappers

import com.grpitsolutions.chat.data.dto.ChatParticipantDTO
import com.grpitsolutions.chat.domain.models.ChatParticipant

fun ChatParticipantDTO.toDomain(): ChatParticipant{
    return ChatParticipant(
        userId = this.userId,
        username = this.username,
        profilePictureUrl = this.profilePictureUrl
    )
}
