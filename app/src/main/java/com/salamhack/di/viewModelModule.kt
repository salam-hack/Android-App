package com.salamhack.di


import com.salamhack.presentation.screen.createAccount.CreateAccountViewModel
import com.salamhack.presentation.screen.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        LoginViewModel()
        CreateAccountViewModel()
    }
}