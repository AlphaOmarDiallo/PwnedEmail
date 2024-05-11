package com.alphaomardiallo.pawnedemail.screens.secure

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.alphaomardiallo.pawnedemail.feature.secure.presentation.SecureComposable

@Composable
fun SecureScreen() {

    val viewModel: SecureScreenViewModel = hiltViewModel()

    LaunchedEffect(key1 = Unit) {
        viewModel.logScreenView()
    }

    SecureComposable()
}
