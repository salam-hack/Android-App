package com.salamhack.presentation.screen.chatBot

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun ChatBotScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Text(
            text = "ChatBotScreen",
            style = Theme.textStyle.header.copy(
                color = Theme.colors.bluePrimary
            )
        )
    }
}

@Preview
@Composable
private fun Preview(){
    ChatBotScreen()
}