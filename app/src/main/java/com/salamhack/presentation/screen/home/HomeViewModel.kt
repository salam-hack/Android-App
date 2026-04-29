package com.salamhack.presentation.screen.home

import com.salamhack.domain.usecase.GetHomeUseCase
import com.salamhack.presentation.shared.utils.BaseViewModel

class HomeViewModel(
    private val getHomeUseCase: GetHomeUseCase
): BaseViewModel<HomeUiState>(HomeUiState()),
    HomeInteractionListener {

    init {
        loadHome()
    }

    fun loadHome(){
        tryToExecute(
            execute = {
                updateState(
                    newState = screenState.value.copy(
                        isLoading = true,
                    )
                )
//                getHomeUseCase()
            },
            onSuccess = {
                updateState(
                    newState = screenState.value.copy(
                        isLoading = false,
//                        data = it
                    )
                )
            },
            onError = {}
        )
    }
}