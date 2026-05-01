package com.salamhack.presentation.screen.notification

import com.salamhack.presentation.shared.utils.BaseViewModel

class NotificationViewModel(): BaseViewModel<NotificationUiState>(NotificationUiState()),
    NotificationInteractionListener {
    override fun onClickBack() {
        navigateUp()
    }

    override fun onClickNotification() {}
}