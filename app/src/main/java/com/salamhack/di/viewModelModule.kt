package com.salamhack.di


import com.salamhack.presentation.screen.addGoal.AddGoalViewModel
import com.salamhack.presentation.screen.addTransaction.AddTransactionViewModel
import com.salamhack.presentation.screen.allGoals.AllGoalsViewModel
import com.salamhack.presentation.screen.allTransaction.AllTransactionViewModel
import com.salamhack.presentation.screen.chatBot.ChatBotViewModel
import com.salamhack.presentation.screen.chatBotHistory.ChatBotHistoryViewModel
import com.salamhack.presentation.screen.createAccount.CreateAccountViewModel
import com.salamhack.presentation.screen.goalDetails.GoalDetailsViewModel
import com.salamhack.presentation.screen.goals.GoalsViewModel
import com.salamhack.presentation.screen.home.HomeViewModel
import com.salamhack.presentation.screen.login.LoginViewModel
import com.salamhack.presentation.screen.newPassword.NewPasswordViewModel
import com.salamhack.presentation.screen.notification.NotificationViewModel
import com.salamhack.presentation.screen.resetPassword.ResetPasswordViewModel
import com.salamhack.presentation.screen.verifyOTP.VerifyOTPViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { LoginViewModel() }
    viewModel { CreateAccountViewModel() }
    viewModel { NewPasswordViewModel() }
    viewModel { ResetPasswordViewModel() }
    viewModel { VerifyOTPViewModel() }
    viewModel { HomeViewModel(get()) }
    viewModel { AddTransactionViewModel(get(), get()) }
    viewModel { ChatBotViewModel(get(), get(), get(), get()) }
    viewModel { ChatBotHistoryViewModel(get()) }
    viewModel { GoalsViewModel() }
    viewModel { NotificationViewModel() }
    viewModel { AllTransactionViewModel() }
    viewModel { AllGoalsViewModel() }
    viewModel { GoalDetailsViewModel() }
    viewModel { GoalDetailsViewModel() }
    viewModel { AddGoalViewModel() }
}