package com.grpitsolutions.chat.domain.chat

import com.grpitsolutions.chat.domain.models.ChatParticipant
import com.grpitsolutions.core.domain.util.DataError
import com.grpitsolutions.core.domain.util.Result

interface ChatParticipantService {
    suspend fun searchChatParticipants(query: String): Result<ChatParticipant, DataError.Remote>
}