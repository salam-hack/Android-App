package com.salamhack.di

import com.salamhack.data.repository.HomeRepositoryImpl
import com.salamhack.domain.repository.HomeRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<HomeRepository> { HomeRepositoryImpl(get()) }
}