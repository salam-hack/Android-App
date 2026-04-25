package com.salamhack

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.salamhack.presentation.navigation.AppNavGraph
import com.salamhack.presentation.navigation.Destinations
import com.salamhack.presentation.shared.designSystem.theme.AppTheme

@Composable
fun AppContent() {

//    val navController = rememberNavController()
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = navBackStackEntry?.destination?.route
//
//    val mainRoutes = setOf(
//        Destinations.Home::class.qualifiedName,
//        Destinations.Scan::class.qualifiedName,
//        Destinations.History::class.qualifiedName,
//        Destinations.Settings::class.qualifiedName
//    )

    AppTheme {
        Scaffold(
            modifier = Modifier.statusBarsPadding(),
            topBar = {
//                if (currentRoute in mainRoutes) {
//                    TopBar()
//                }
            },
            bottomBar = {
//                if (currentRoute in mainRoutes) {
//                    NavBar(navController)
//                }
            },
        ) { innerPadding ->
            Box(
                modifier = Modifier.padding(innerPadding)
            ){
//                AppNavGraph(
//                    navController = navController,
//                )
            }
        }
    }
}