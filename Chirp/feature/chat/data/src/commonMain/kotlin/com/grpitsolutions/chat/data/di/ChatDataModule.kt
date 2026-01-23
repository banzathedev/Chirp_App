package com.grpitsolutions.chat.data.di

import com.grpitsolutions.chat.data.chat.KtorChatParticipantService
import com.grpitsolutions.chat.domain.chat.ChatParticipantService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val chatDataModule = module {
    singleOf(::KtorChatParticipantService) bind ChatParticipantService::class
}