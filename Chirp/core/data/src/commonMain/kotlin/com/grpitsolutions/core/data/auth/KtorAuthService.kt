package com.grpitsolutions.core.data.auth

import com.grpitsolutions.core.data.dto.AuthInfoSerializable
import com.grpitsolutions.core.data.dto.request.EmailRequest
import com.grpitsolutions.core.data.dto.request.LoginRequest
import com.grpitsolutions.core.data.dto.request.RegisterRequest
import com.grpitsolutions.core.data.mappers.toDomain
import com.grpitsolutions.core.data.networking.get
import com.grpitsolutions.core.data.networking.post
import com.grpitsolutions.core.domain.auth.AuthInfo
import com.grpitsolutions.core.domain.auth.AuthService
import com.grpitsolutions.core.domain.util.DataError
import com.grpitsolutions.core.domain.util.EmptyResult
import com.grpitsolutions.core.domain.util.Result
import com.grpitsolutions.core.domain.util.map
import io.ktor.client.HttpClient

class KtorAuthService(
    private val httpClient: HttpClient
) : AuthService {
    override suspend fun login(
        email: String,
        password: String
    ): Result<AuthInfo, DataError.Remote> {
        return httpClient.post<LoginRequest, AuthInfoSerializable>(
            route = "/auth/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        ).map { authInfoSerializable ->
            authInfoSerializable.toDomain()
        }
    }

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

    override suspend fun resendVerificationEmail(email: String): EmptyResult<DataError.Remote> {
        return httpClient.post(
            route = "/auth/resend-verification",
            body = EmailRequest(email)
        )
    }

    override suspend fun verifyEmail(token: String): EmptyResult<DataError.Remote> {
        return httpClient.get(
            route = "/auth/verify",
            queryParams = mapOf("token" to token)
        )
    }

    override suspend fun forgotPassword(email: String): EmptyResult<DataError.Remote> {
        return httpClient.post(
            route = "/auth/forgot-password",
            body = EmailRequest(email)
        )
    }
}