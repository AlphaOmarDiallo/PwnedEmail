package com.alphaomardiallo.pawnedemail.screens.breaches

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.alphaomardiallo.pawnedemail.common.presentation.theme.largePadding
import com.alphaomardiallo.pawnedemail.feature.breachesregistered.presentation.AllBreachesComposable

@Composable
fun BreachesScreen() {

    val viewModel: BreachesScreenViewModel = hiltViewModel()

    LaunchedEffect(key1 = Unit) {
        viewModel.logScreenView()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(largePadding())
    ) {
        AllBreachesComposable()
    }
}
