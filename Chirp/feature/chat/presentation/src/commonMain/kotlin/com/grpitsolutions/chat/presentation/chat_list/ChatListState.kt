package com.grpitsolutions.chat.presentation.chat_list

import com.grpitsolutions.chat.domain.models.ChatParticipant
import com.grpitsolutions.chat.presentation.model.ChatUi
import com.grpitsolutions.core.designsystem.components.avatar.ChatParticipantUi
import com.grpitsolutions.core.presentation.util.UiText

data class ChatListState(
    val chats: List<ChatUi> = emptyList(),
    val error: UiText? = null,
    val localParticipant: ChatParticipantUi? = null,
    val isUserMenuOpen: Boolean = false,
    val showLogoutConfirmation: Boolean = false,
    val selectedChatId: String? = null
)