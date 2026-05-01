package com.salamhack.di

import com.salamhack.data.source.remote.chatBot.ChatRemoteDataSource
import com.salamhack.data.source.remote.chatBot.ChatRemoteDataSourceImpl
import com.salamhack.data.source.remote.home.HomeRemoteDataSource
import com.salamhack.data.source.remote.home.HomeRemoteDataSourceImpl
import com.salamhack.data.source.remote.transaction.TransactionRemoteDataSource
import com.salamhack.data.source.remote.transaction.TransactionRemoteDataSourceImpl
import org.koin.dsl.module

val dataModule = module {
    single<HomeRemoteDataSource> { HomeRemoteDataSourceImpl(get()) }
    single<TransactionRemoteDataSource> { TransactionRemoteDataSourceImpl(get()) }
    single<ChatRemoteDataSource> { ChatRemoteDataSourceImpl(get()) }
}