package com.salamhack.presentation.screen.newPassword

data class NewPasswordUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val password: String = "",
    val rePassword: String = "",
)
