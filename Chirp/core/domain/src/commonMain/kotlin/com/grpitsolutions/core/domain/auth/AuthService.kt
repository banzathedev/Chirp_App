package com.grpitsolutions.core.domain.auth

import com.grpitsolutions.core.domain.util.DataError
import com.grpitsolutions.core.domain.util.EmptyResult

interface AuthService {
    suspend fun register(
        email: String,
        password: String,
        username: String
    ): EmptyResult<DataError.Remote>
}