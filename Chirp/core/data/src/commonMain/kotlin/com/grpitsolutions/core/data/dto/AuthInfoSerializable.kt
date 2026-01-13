package com.grpitsolutions.core.data.dto

import com.grpitsolutions.core.domain.auth.User
import kotlinx.serialization.Serializable

@Serializable
data class AuthInfoSerializable(
    val accessToken: String,
    val refreshToken: String,
    val user: UserSerializable,
)
