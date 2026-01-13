package com.grpitsolutions.core.data.mappers

import com.grpitsolutions.core.data.dto.AuthInfoSerializable
import com.grpitsolutions.core.domain.auth.AuthInfo

fun AuthInfoSerializable.toDomain(): AuthInfo {
    return AuthInfo(
        accessToken = accessToken,
        refreshToken = refreshToken,
        user = user.toDomain()
    )
}

