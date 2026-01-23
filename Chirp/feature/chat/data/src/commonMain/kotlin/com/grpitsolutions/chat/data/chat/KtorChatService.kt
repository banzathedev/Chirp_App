package com.grpitsolutions.chat.data.chat

import com.grpitsolutions.chat.data.dto.request.CreateChatRequestDTO
import com.grpitsolutions.chat.data.dto.response.ChatDTO
import com.grpitsolutions.chat.data.mappers.toDomain
import com.grpitsolutions.chat.domain.chat.ChatService
import com.grpitsolutions.chat.domain.models.Chat
import com.grpitsolutions.core.data.networking.post
import com.grpitsolutions.core.domain.util.DataError
import com.grpitsolutions.core.domain.util.Result
import com.grpitsolutions.core.domain.util.map
import io.ktor.client.HttpClient

class KtorChatService(
    private val httpClient: HttpClient
): ChatService {
    override suspend fun createChat(otherUserId: List<String>): Result<Chat, DataError.Remote> {
        return httpClient.post<CreateChatRequestDTO, ChatDTO>(
            route = "/chat",
            body = CreateChatRequestDTO(
                otherUserIds = otherUserId
            )
        ).map { it.toDomain() }
    }
}