package com.grpitsolutions.chat.data.chat

import com.grpitsolutions.chat.data.dto.response.ChatParticipantDTO
import com.grpitsolutions.chat.data.mappers.toDomain
import com.grpitsolutions.chat.domain.chat.ChatParticipantService
import com.grpitsolutions.chat.domain.models.ChatParticipant
import com.grpitsolutions.core.data.networking.get
import com.grpitsolutions.core.domain.util.DataError
import com.grpitsolutions.core.domain.util.Result
import com.grpitsolutions.core.domain.util.map
import io.ktor.client.HttpClient

class KtorChatParticipantService(
    private val httpClient: HttpClient
): ChatParticipantService {
    override suspend fun searchChatParticipants(query: String): Result<ChatParticipant, DataError.Remote> {
        return httpClient.get<ChatParticipantDTO>(
            route = "/participants",
            queryParams = mapOf("query" to query)
        ).map { it.toDomain() }
    }
}