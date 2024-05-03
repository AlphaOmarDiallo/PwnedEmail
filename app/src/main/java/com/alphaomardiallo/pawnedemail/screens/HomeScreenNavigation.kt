package com.alphaomardiallo.pawnedemail.screens

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.homeScreenNavigation(): NavGraphBuilder = this.apply {
    composable(route = HomeScreenDestination.Home.route) {
        HomeScreen()
    }
}
