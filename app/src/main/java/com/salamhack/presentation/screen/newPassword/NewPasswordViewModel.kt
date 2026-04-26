package com.salamhack.presentation.screen.newPassword

import com.salamhack.presentation.navigation.Destinations
import com.salamhack.presentation.shared.utils.BaseViewModel

class NewPasswordViewModel(): BaseViewModel<NewPasswordUiState>(NewPasswordUiState()),
    NewPasswordInteractionListener {
    override fun onClickSavePassword() {
        navigate(Destinations.Home)
    }

    override fun onClickLogin() {
        navigate(Destinations.Login)
    }
}