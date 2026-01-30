package com.grpitsolutions.chat.presentation.mappers

import com.grpitsolutions.chat.domain.models.Chat
import com.grpitsolutions.chat.presentation.model.ChatUi

fun Chat.toUi(localParticipantId: String): ChatUi{
    val (local, other) = participants.partition { it.userId == localParticipantId }
    return ChatUi(
        id = id,
        localParticipant = local.first().toUi(),
        otherParticipants = other.map { it.toUi() },
        lastMessage = lastMessage,
        lastMessageSenderUsername = participants.find { it.username == lastMessage?.senderId }?.username
    )
}