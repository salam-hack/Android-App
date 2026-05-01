package com.salamhack.di

import com.salamhack.data.repository.ChatRepositoryImpl
import com.salamhack.data.repository.HomeRepositoryImpl
import com.salamhack.data.repository.TransactionRepositoryImpl
import com.salamhack.domain.repository.ChatRepository
import com.salamhack.domain.repository.HomeRepository
import com.salamhack.domain.repository.TransactionRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<HomeRepository> { HomeRepositoryImpl(get()) }
    single<TransactionRepository> { TransactionRepositoryImpl(get()) }
    single<ChatRepository> { ChatRepositoryImpl(get()) }
}