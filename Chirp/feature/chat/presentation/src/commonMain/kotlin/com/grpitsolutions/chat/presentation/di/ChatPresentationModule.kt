package com.grpitsolutions.chat.presentation.di

import com.grpitsolutions.chat.presentation.chat_list.ChatListViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val chatPresentationModule = module {
    singleOf(::ChatListViewModel)
}