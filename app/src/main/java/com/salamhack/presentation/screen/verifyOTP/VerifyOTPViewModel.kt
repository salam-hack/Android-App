package com.salamhack.presentation.screen.verifyOTP

import com.salamhack.presentation.navigation.Destinations
import com.salamhack.presentation.shared.utils.BaseViewModel

class VerifyOTPViewModel(): BaseViewModel<VerifyOTPUiState>(VerifyOTPUiState()),
    VerifyOTPInteractionListener {
    override fun onClickVerify() {
        navigate(Destinations.Home)
    }

    override fun onClickResendCode() {}

}