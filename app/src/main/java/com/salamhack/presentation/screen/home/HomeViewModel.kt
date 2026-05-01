package com.salamhack.presentation.screen.home

import android.util.Log
import com.salamhack.domain.usecase.GetHomeUseCase
import com.salamhack.presentation.navigation.Destinations
import com.salamhack.presentation.shared.utils.BaseViewModel

class HomeViewModel(
    private val getHomeUseCase: GetHomeUseCase
): BaseViewModel<HomeUiState>(HomeUiState()),
    HomeInteractionListener {

    private val userId = "550e8400-e29b-41d4-a716-446655440001"

    init {
        loadHome()
    }

    fun loadHome() {
        tryToObserve(
            observe = {
                getHomeUseCase(userId = userId)
            },
            onStart = {
                updateState(
                    newState = screenState.value.copy(
                        isLoading = true,
                        error = null
                    )
                )
            },
            onEach = { result ->
                Log.d("home", "loadHome: $result")
                result?.fold(
                    onSuccess = { homeEntity ->
                        updateState(
                            newState = screenState.value.copy(
                                isLoading = false,
                                data = homeEntity,
                                error = null
                            )
                        )
                    },
                    onFailure = { error ->
                        updateState(
                            newState = screenState.value.copy(
                                isLoading = false,
                                error = error.message ?: "حدث خطأ غير متوقع"
                            )
                        )
                    }
                )
            },
            onError = { throwable ->
                updateState(
                    newState = screenState.value.copy(
                        isLoading = false,
                        error = throwable.message ?: "حدث خطأ في النظام"
                    )
                )
            }
        )
    }

    override fun onClickNotification() {
        navigate(Destinations.Notification)
    }


    override fun onClickAddTransaction() {
        navigate(Destinations.AddTransaction)
    }

    override fun onClickViewAllTransaction() {
        navigate(Destinations.AllTransaction)
    }
}