package com.salamhack.presentation.screen.obligations

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.salamhack.presentation.shared.designSystem.theme.Theme


@Composable
fun ObligationsScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Text(
            text = "ObligationsScreen",
            style = Theme.textStyle.header.copy(
                color = Theme.colors.bluePrimary
            )
        )
    }
}

@Preview
@Composable
private fun Preview(){
    ObligationsScreen()
}