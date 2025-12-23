package com.grpitsolutions.core.data.di

import com.grpitsolutions.core.data.logging.KermitLogger
import com.grpitsolutions.core.data.networking.HttpClientFactory
import com.grpitsolutions.core.domain.logging.ChirpLogger
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val coreDataModule = module {
    single<ChirpLogger> { KermitLogger }
    single {
        HttpClientFactory(get()).create()
    }
}