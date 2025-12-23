package com.grpitsolutions.chirp.di

import com.grpitsolutions.auth.presentation.di.authPresentationModule
import com.grpitsolutions.core.data.di.coreDataModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null){
    startKoin {
        config?.invoke(this)
        modules(
            coreDataModule,
            authPresentationModule
        )
    }
}