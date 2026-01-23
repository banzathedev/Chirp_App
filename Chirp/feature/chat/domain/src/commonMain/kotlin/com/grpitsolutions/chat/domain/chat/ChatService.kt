package com.grpitsolutions.chat.domain.chat

import com.grpitsolutions.chat.domain.models.Chat
import com.grpitsolutions.core.domain.util.DataError
import com.grpitsolutions.core.domain.util.Result

interface ChatService {
    suspend fun createChat(
        otherUserId: List<String>
    ): Result<Chat, DataError.Remote>
}