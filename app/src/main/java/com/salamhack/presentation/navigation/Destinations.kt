package com.salamhack.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.salamhack.presentation.screen.addTransaction.AddTransactionScreen
import com.salamhack.presentation.screen.chatBot.ChatBotScreen
import com.salamhack.presentation.screen.createAccount.CreateAccountScreen
import com.salamhack.presentation.screen.goals.GoalsScreen
import com.salamhack.presentation.screen.home.HomeScreen
import com.salamhack.presentation.screen.login.LoginScreen
import com.salamhack.presentation.screen.more.MoreScreen
import com.salamhack.presentation.screen.newPassword.NewPasswordScreen
import com.salamhack.presentation.screen.obligations.ObligationsScreen
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

    @Serializable
    data object AddTransaction : Destination

    @Serializable
    data object Goals : Destination

    @Serializable
    data object More : Destination

    @Serializable
    data object Obligations : Destination

    @Serializable
    data object ChatBot : Destination

}

fun NavGraphBuilder.buildAppNavGraph() {
    navigation<Destinations.AppGraph>(startDestination = Destinations.Login) {
        composable<Destinations.Home> { HomeScreen() }
        composable<Destinations.Login> { LoginScreen() }
        composable<Destinations.CreateAccount> { CreateAccountScreen() }
        composable<Destinations.NewPassword> { NewPasswordScreen() }
        composable<Destinations.ResetPassword> { ResetPasswordScreen() }
        composable<Destinations.VerifyOTP> { VerifyOTPScreen() }
        composable<Destinations.AddTransaction> { AddTransactionScreen() }
        composable<Destinations.AddTransaction> { GoalsScreen() }
        composable<Destinations.AddTransaction> { MoreScreen() }
        composable<Destinations.AddTransaction> { ObligationsScreen() }
        composable<Destinations.AddTransaction> { ChatBotScreen() }
    }
}