package com.grpitsolutions.core.data.auth

import com.grpitsolutions.core.data.dto.request.RegisterRequest
import com.grpitsolutions.core.data.networking.post
import com.grpitsolutions.core.domain.auth.AuthService
import com.grpitsolutions.core.domain.util.DataError
import com.grpitsolutions.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class KtorAuthService(
    private val httpClient: HttpClient
) : AuthService {
    override suspend fun register(
        email: String,
        password: String,
        username: String
    ): EmptyResult<DataError.Remote> {
        return httpClient.post(
            route = "/auth/register",
            body = RegisterRequest(
                email = email,
                password = password,
                username = username
            )
        )
    }
}