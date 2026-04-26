package com.salamhack.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.salamhack.presentation.screen.createAccount.CreateAccountScreen
import com.salamhack.presentation.screen.home.HomeScreen
import com.salamhack.presentation.screen.login.LoginScreen
import com.salamhack.presentation.screen.newPassword.NewPasswordScreen
import com.salamhack.presentation.screen.resetPassword.ResetPasswordScreen
import com.salamhack.presentation.screen.verifyOTP.VerifyOTPScreen
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

    @Serializable
    data object Login : Destination

    @Serializable
    data object CreateAccount : Destination

    @Serializable
    data object NewPassword : Destination

    @Serializable
    data object ResetPassword : Destination

    @Serializable
    data object VerifyOTP : Destination


}

fun NavGraphBuilder.buildAppNavGraph() {
    navigation<Destinations.AppGraph>(startDestination = Destinations.Login) {
        composable<Destinations.Home> { HomeScreen() }
        composable<Destinations.Login> { LoginScreen() }
        composable<Destinations.CreateAccount> { CreateAccountScreen() }
        composable<Destinations.NewPassword> { NewPasswordScreen() }
        composable<Destinations.ResetPassword> { ResetPasswordScreen() }
        composable<Destinations.VerifyOTP> { VerifyOTPScreen() }
    }
}