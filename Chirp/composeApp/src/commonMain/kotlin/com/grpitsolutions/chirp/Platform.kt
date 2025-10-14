package com.grpitsolutions.chirp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform