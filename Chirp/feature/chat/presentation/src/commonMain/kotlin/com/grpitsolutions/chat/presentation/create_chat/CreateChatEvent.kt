package com.grpitsolutions.chat.presentation.create_chat

import com.grpitsolutions.chat.domain.models.Chat

interface CreateChatEvent {
    data class OnChatCreated(
        val chat: Chat
    ): CreateChatEvent
}