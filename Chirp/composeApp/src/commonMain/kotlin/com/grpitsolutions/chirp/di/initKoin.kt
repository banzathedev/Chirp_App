package com.grpitsolutions.chirp.di

import com.grpitsolutions.auth.presentation.di.authPresentationModule
import com.grpitsolutions.chat.data.di.chatDataModule
import com.grpitsolutions.chat.presentation.di.chatPresentationModule
import com.grpitsolutions.core.data.di.coreDataModule
import com.grpitsolutions.core.presentation.di.corePresentationModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null){
    startKoin {
        config?.invoke(this)
        modules(
            appModule,
            coreDataModule,
            corePresentationModule,
            authPresentationModule,
            chatPresentationModule,
            chatDataModule
        )
    }
}