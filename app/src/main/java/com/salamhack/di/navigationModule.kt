package com.salamhack.di

import com.salamhack.presentation.navigation.Destinations
import com.salamhack.presentation.navigation.Navigator
import com.salamhack.presentation.navigation.NavigatorImpl
import org.koin.dsl.module

val navigationModule = module {
    single <Navigator>{ NavigatorImpl(startGraph = Destinations.AppGraph) }
}