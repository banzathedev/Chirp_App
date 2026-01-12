package com.grpitsolutions.core.domain.auth

import com.grpitsolutions.core.domain.util.DataError
import com.grpitsolutions.core.domain.util.EmptyResult

interface AuthService {
    suspend fun register(
        email: String,
        password: String,
        username: String
    ): EmptyResult<DataError.Remote>

    suspend fun resendVerificationEmail(email: String): EmptyResult<DataError.Remote>

    suspend fun verifyEmail(token: String): EmptyResult<DataError.Remote>
}