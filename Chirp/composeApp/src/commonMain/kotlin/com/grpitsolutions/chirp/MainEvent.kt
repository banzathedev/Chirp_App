package com.grpitsolutions.chirp

sealed interface MainEvent {
    data object OnSessionExpired: MainEvent
}