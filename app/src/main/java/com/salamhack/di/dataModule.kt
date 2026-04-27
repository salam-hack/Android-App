package com.salamhack.di

import com.salamhack.data.remote.home.HomeRemoteDataSource
import com.salamhack.data.remote.home.HomeRemoteDataSourceImpl
import org.koin.dsl.module

val dataModule = module {
    single<HomeRemoteDataSource> { HomeRemoteDataSourceImpl(get()) }
}