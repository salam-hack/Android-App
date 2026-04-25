package com.salamhack.presentation.navigation

import androidx.navigation.NavOptions

sealed class NavigationEvent {
    data class Navigate(val destination: Destination, val navOptions: NavOptions? = null) :
        NavigationEvent()

    data object NavigateUp : NavigationEvent()
}