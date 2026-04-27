package com.salamhack.presentation.screen.resetPassword

import com.salamhack.presentation.navigation.Destinations
import com.salamhack.presentation.shared.utils.BaseViewModel

class ResetPasswordViewModel(): BaseViewModel<ResetPasswordUiState>(ResetPasswordUiState()),
    ResetPasswordInteractionListener {
    override fun onClickSendCode() {
        navigate(Destinations.VerifyOTP)
    }

    override fun onClickLogin() {
        navigate(Destinations.Login)
    }
}