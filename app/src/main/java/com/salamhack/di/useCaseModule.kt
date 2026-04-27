package com.salamhack.di

import com.salamhack.domain.usecase.GetHomeUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory { GetHomeUseCase(get()) }
}