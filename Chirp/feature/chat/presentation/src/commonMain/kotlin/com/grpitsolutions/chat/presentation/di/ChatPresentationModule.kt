package com.grpitsolutions.chat.presentation.di

import com.grpitsolutions.chat.presentation.chat_list.ChatListViewModel
import com.grpitsolutions.chat.presentation.chat_list_detail.ChatListDetailViewModel
import com.grpitsolutions.chat.presentation.create_chat.CreateChatViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val chatPresentationModule = module {
    singleOf(::ChatListViewModel)
    singleOf(::ChatListDetailViewModel)
    singleOf(::CreateChatViewModel)
}