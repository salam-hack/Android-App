package com.salamhack.di

import com.salamhack.domain.repository.TransactionRepository
import com.salamhack.domain.usecase.CreateConversationUseCase
import com.salamhack.domain.usecase.GetHomeUseCase
import com.salamhack.domain.usecase.ParseTransactionUseCase
import com.salamhack.domain.usecase.SendMessageUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory { GetHomeUseCase(get()) }
    factory { ParseTransactionUseCase(get()) }
    factory { SendMessageUseCase(get()) }
    factory { CreateConversationUseCase(get()) }
}