package com.salamhack.presentation.screen.createAccount

import com.salamhack.presentation.navigation.Destinations
import com.salamhack.presentation.shared.utils.BaseViewModel

class CreateAccountViewModel(): BaseViewModel<CreateAccountUiState>(CreateAccountUiState()), CreateAccountInteractionListener {
    override fun onClickCreate() {
        navigate(Destinations.VerifyOTP)
    }

    override fun onClickLogin() {
        navigate(Destinations.Login)
    }

}