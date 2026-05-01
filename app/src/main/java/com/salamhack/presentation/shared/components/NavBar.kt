package com.salamhack.presentation.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.salamhack.R
import com.salamhack.presentation.navigation.Destination
import com.salamhack.presentation.navigation.Destinations
import com.salamhack.presentation.navigation.Navigator
import com.salamhack.presentation.shared.designSystem.theme.Theme
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun NavBar(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    navigator: Navigator = koinInject()
){

    val navItems = listOf(
        NavItemData("الأهداف", R.drawable.ic_target, Destinations.Goals),
        NavItemData("الرئيسية", R.drawable.ic_home, Destinations.Home),
        NavItemData("المزيد", R.drawable.ic_more, Destinations.More),
        NavItemData("الالتزامات", R.drawable.ic_obligations, Destinations.Obligations)
    )

    val coroutineScope = rememberCoroutineScope()

    val currentBackStackEntry by navHostController.currentBackStackEntryAsState()

    val selectedIndex by remember(currentBackStackEntry) {
        derivedStateOf {
            navItems.indexOfFirst { item ->
                currentBackStackEntry?.destination?.hasRoute(item.destination::class) == true
            }.coerceAtLeast(0)
        }
    }


    Box(
        modifier = modifier
            .padding(horizontal = 18.dp)
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .clip(CircleShape)
                .drawWithContent {

                    drawContent()

                    val strokeWidth = 1.dp.toPx()

                    drawRoundRect(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFE2E8F0),
                                Color.Transparent
                            )
                        ),
                        style = Stroke(width = strokeWidth),
                        cornerRadius = CornerRadius(size.height / 2f)
                    )
                }
        ){
            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(vertical = 12.dp, horizontal = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(38.dp)
            ) {
                NavItem(
                    text = navItems[0].text,
                    icon = navItems[0].icon,
                    isSelected = selectedIndex == 0,
                    onClick = {
                        coroutineScope.launch {
                            navigator.navigate(navItems[0].destination)
                        }
                    }
                )

                NavItem(
                    text = navItems[1].text,
                    icon = navItems[1].icon,
                    isSelected = selectedIndex == 1,
                    onClick = {
                        coroutineScope.launch {
                            navigator.navigate(navItems[1].destination)
                        }
                    }
                )
            }

            Row(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(vertical = 12.dp, horizontal = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(38.dp)
            ) {
                NavItem(
                    text = navItems[2].text,
                    icon = navItems[2].icon,
                    isSelected = selectedIndex == 2,
                    onClick = {
                        coroutineScope.launch {
                            navigator.navigate(navItems[2].destination)
                        }
                    }
                )

                NavItem(
                    text = navItems[3].text,
                    icon = navItems[3].icon,
                    isSelected = selectedIndex == 3,
                    onClick = {
                        coroutineScope.launch {
                            navigator.navigate(navItems[3].destination)
                        }
                    }
                )
            }
        }
        val glow = Modifier.drawBehind {

            val blurRadius = 40f

            drawIntoCanvas { canvas ->

                val paint = android.graphics.Paint().apply {
                    color = android.graphics.Color.TRANSPARENT
                    isAntiAlias = true
                    setShadowLayer(
                        blurRadius,
                        0f,
                        0f,
                        android.graphics.Color.argb(102, 212, 175, 55)
                    )
                }

                canvas.nativeCanvas.drawRoundRect(
                    0f,
                    0f,
                    size.width,
                    size.height,
                    16.dp.toPx(),
                    16.dp.toPx(),
                    paint
                )
            }
        }

        Box(
            modifier = modifier
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFD4AF37),
                            Color(0xFFE5C662)
                        ),
                        start = Offset(0f, Float.POSITIVE_INFINITY),
                        end = Offset(Float.POSITIVE_INFINITY, 0f)
                    ),
                    shape = CircleShape
                )
                .border(
                    width = 4.dp,
                    color = Theme.colors.white,
                    shape = CircleShape
                )
                .size(60.dp)
                .align(Alignment.TopCenter)
                .then(glow)
                .clickable {
                    coroutineScope.launch {
                        navigator.navigate(Destinations.ChatBot())
                    }
                }
        ){
            Icon(
                painter = painterResource(R.drawable.ic_star),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(28.dp)
            )
        }

        Text(
            text = "رشيد",
            style = Theme.textStyle.title.regular.copy(
                fontSize = 10.sp,
                color = Color(0xFF0F3A70)
            ),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp)
        )
    }

}

@Composable
fun NavItem(
    modifier: Modifier = Modifier,
    text: String = "الرئيسية",
    icon: Int = R.drawable.ic_home,
    isSelected: Boolean = true,
    onClick: () -> Unit,
){
    val color = if (isSelected) Color(0xFF0F3A70) else Color(0xFF90A1B9)

    Box(
        modifier = modifier
            .clickable { onClick() },
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                tint = color,
            )
            Text(
                text = text,
                style = Theme.textStyle.title.regular.copy(
                    fontSize = 10.sp,
                    color = color
                ),
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 1.5.dp)
            )
            if (isSelected){
                Box(
                    modifier = modifier
                        .background(Color(0xFF0F3A70), shape = CircleShape)
                        .height(4.dp)
                        .width(12.dp)
                )
            }
        }
    }
}

data class NavItemData(
    val text: String,
    val icon: Int,
    val destination: Destination
)

@Preview
@Composable
private fun Preview(){
    NavBar(
        navHostController = NavHostController(LocalContext.current)
    )
}