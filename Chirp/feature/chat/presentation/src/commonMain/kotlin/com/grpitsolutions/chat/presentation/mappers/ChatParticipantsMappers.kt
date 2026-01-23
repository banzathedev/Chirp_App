package com.grpitsolutions.chat.presentation.mappers

import com.grpitsolutions.chat.domain.models.ChatParticipant
import com.grpitsolutions.core.designsystem.components.avatar.ChatParticipantUi

fun ChatParticipant.toUi(): ChatParticipantUi{

    return ChatParticipantUi(
        id = this.userId,
        username = this.username,
        initials = this.initials,
        imageUrl = this.profilePictureUrl
    )
}