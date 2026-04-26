package com.salamhack.presentation.screen.login

import com.salamhack.presentation.navigation.Destinations
import com.salamhack.presentation.shared.utils.BaseViewModel
import kotlinx.coroutines.delay

class LoginViewModel(): BaseViewModel<LoginUiState>(LoginUiState()), LoginInteractionListener {

    fun checkUserIsLoggedIn(){
        tryToExecute(
            onSuccess = {
                updateState(
                    newState = screenState.value.copy(
                        isLoading = false,
                        error = null
                    )
                )
                navigate(Destinations.Home)
            },
            onError = {
                updateState(
                    newState = screenState.value.copy(
                        isLoading = false,
                        error = "Something went wrong"
                    )
                )
            },
            execute = {
                updateState(
                    newState = screenState.value.copy(
                        isLoading = true,
                    )
                )
                delay(1000)
            }
        )
    }

    override fun onClickLogin() {
        navigate(Destinations.Home)
    }

    override fun onClickForgotPassword() {
        navigate(Destinations.ResetPassword)
    }

    override fun onClickSignUp() {
        navigate(Destinations.CreateAccount)
    }
}