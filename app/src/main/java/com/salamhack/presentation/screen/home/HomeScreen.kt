package com.salamhack.presentation.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Text(
            text = "الرئيسية",
            fontSize = 28.sp,
            color = Color(0xFF003D9B),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 31.dp)
                .align(Alignment.Center)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Preview(){
    HomeScreen()
}