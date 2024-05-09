package com.alphaomardiallo.pawnedemail.common.presentation.mainactivity.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.alphaomardiallo.pawnedemail.common.presentation.mainactivity.destination.BottomNavDestination

@Composable
fun MainScaffold(
    navController: NavHostController,
    navBackStackEntry: NavBackStackEntry?,
    navItems: List<BottomNavDestination>,
    content: @Composable (PaddingValues) -> Unit,
) {

    var showNavigationBar by rememberSaveable { mutableStateOf(false) }
    var showAppBar by rememberSaveable { mutableStateOf(false) }
    var selectedBarItem by rememberSaveable { mutableIntStateOf(0) }
    var currentRoute by rememberSaveable { mutableStateOf(BottomNavDestination.Home.route) }

    navBackStackEntry?.destination?.route?.let { route ->
        when (route) {
            else -> {
                showAppBar = true
                showNavigationBar = true
            }
        }
    }

    Scaffold(
        topBar = {
            MainAppBar()
        },
        bottomBar = {
            MainBottomBar(
                isNavigationBarVisible = showNavigationBar,
                items = navItems,
                currentRoute = currentRoute,
                selectedItemIndex = selectedBarItem,
                onSelectedItemChange = { index ->
                    selectedBarItem = index
                }
            ) { route ->
                currentRoute = route
                navController.navigate(route) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route = route) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }

            }
        }
    ) { paddingValues ->
        content(paddingValues)
    }
}
