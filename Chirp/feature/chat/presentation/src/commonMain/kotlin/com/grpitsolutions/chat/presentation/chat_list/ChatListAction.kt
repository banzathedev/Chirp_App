package com.grpitsolutions.chat.presentation.chat_list

sealed interface ChatListAction {
    data object OnUserAvatarClick: ChatListAction
    data object OnDismissMenu: ChatListAction
    data object OnLogoutClick: ChatListAction
    data object OnConfirmLogout: ChatListAction
    data object OnDismissLogoutDialog: ChatListAction
    data class OnChatClick(
        val chatId: String
    ): ChatListAction
}