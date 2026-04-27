package com.salamhack.presentation.screen.home

import com.salamhack.domain.entity.HomeEntity

data class HomeUiState(
    val isLoading: Boolean = false,
    val data: HomeEntity? = null,
    val error: String? = null
)