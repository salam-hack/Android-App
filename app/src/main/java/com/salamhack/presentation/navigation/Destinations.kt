package com.salamhack.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.salamhack.presentation.screen.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
sealed interface Destination

@Serializable
sealed interface Graph : Destination

@Serializable
sealed interface Destinations : Graph {

    @Serializable
    data object AppGraph : Graph

    @Serializable
    data object Home : Destination

}

fun NavGraphBuilder.buildAppNavGraph() {
    navigation<Destinations.AppGraph>(startDestination = Destinations.Home) {
        composable<Destinations.Home> { HomeScreen() }
    }
}