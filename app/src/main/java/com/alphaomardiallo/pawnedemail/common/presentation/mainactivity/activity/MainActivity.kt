package com.alphaomardiallo.pawnedemail.common.presentation.mainactivity.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.alphaomardiallo.pawnedemail.common.presentation.composable.MainScaffold
import com.alphaomardiallo.pawnedemail.common.presentation.mainactivity.destination.BottomNavDestination
import com.alphaomardiallo.pawnedemail.common.presentation.mainactivity.destination.NavigationEffects
import com.alphaomardiallo.pawnedemail.common.presentation.mainactivity.viewmodel.MainViewModel
import com.alphaomardiallo.pawnedemail.common.presentation.theme.PawnedEmailTheme
import com.alphaomardiallo.pawnedemail.screens.breaches.BreachesScreen
import com.alphaomardiallo.pawnedemail.screens.home.HomeScreen
import com.alphaomardiallo.pawnedemail.screens.secure.SecureScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navBarItems = listOf(
            BottomNavDestination.Home,
            BottomNavDestination.Breaches,
            BottomNavDestination.Secure
        )

        installSplashScreen()

        setContent {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()

            NavigationEffects(
                navigationChannel = viewModel.navigationChannel,
                navHostController = navController
            )

            PawnedEmailTheme {

                MainScaffold(
                    navController = navController,
                    navBackStackEntry = navBackStackEntry,
                    navItems = navBarItems
                ) { paddingValues ->

                    Surface(
                        color = MaterialTheme.colorScheme.surfaceBright,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = BottomNavDestination.Home.route
                        ) {
                            bottomBarNavigation()
                            //homeScreenNavigation()
                        }
                    }
                }
            }
        }
    }

    private fun NavGraphBuilder.bottomBarNavigation(): NavGraphBuilder = this.apply {
        composable(route = BottomNavDestination.Home.route) {
            HomeScreen()
        }

        composable(route = BottomNavDestination.Secure.route) {
            SecureScreen()
        }

        composable(route = BottomNavDestination.Breaches.route) {
            BreachesScreen()
        }
    }
}
