package com.alphaomardiallo.pawnedemail.common.presentation.mainactivity.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.alphaomardiallo.pawnedemail.common.presentation.mainactivity.composable.MainScaffold
import com.alphaomardiallo.pawnedemail.common.presentation.mainactivity.destination.NavigationEffects
import com.alphaomardiallo.pawnedemail.common.presentation.mainactivity.viewmodel.MainViewModel
import com.alphaomardiallo.pawnedemail.common.presentation.theme.PawnedEmailTheme
import com.alphaomardiallo.pawnedemail.screens.HomeScreenDestination
import com.alphaomardiallo.pawnedemail.screens.homeScreenNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            //val navBackStackEntry by navController.currentBackStackEntryAsState()

            NavigationEffects(
                navigationChannel = viewModel.navigationChannel,
                navHostController = navController
            )

            PawnedEmailTheme {

                MainScaffold { paddingValues ->

                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = HomeScreenDestination.Home.route
                        ) {
                            homeScreenNavigation()
                        }
                    }
                }
            }
        }
    }
}
