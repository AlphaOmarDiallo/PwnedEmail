package com.alphaomardiallo.pawnedemail.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.alphaomardiallo.pawnedemail.common.presentation.theme.largePadding
import com.alphaomardiallo.pawnedemail.feature.appintroduction.presentation.AppIntroComposable
import com.alphaomardiallo.pawnedemail.feature.breachlist.presentation.BreachListComposable
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.presentation.GetAllBreachesComposable

@Preview
@Composable
fun HomeScreen() {

    val viewModel: HomeScreenViewModel = hiltViewModel()

    LaunchedEffect(key1 = Unit) {
        viewModel.logScreenView()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(largePadding())
            .verticalScroll(rememberScrollState())
    ) {
        AppIntroComposable()
        GetAllBreachesComposable()
        BreachListComposable()
    }
}
