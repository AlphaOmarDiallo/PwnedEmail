package com.alphaomardiallo.pawnedemail.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alphaomardiallo.pawnedemail.common.presentation.theme.largePadding
import com.alphaomardiallo.pawnedemail.feature.appintroduction.presentation.AppIntroComposable
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.presentation.GetAllBreachesComposable

@Preview
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(largePadding())
            .verticalScroll(rememberScrollState())
    ) {
        AppIntroComposable()
        GetAllBreachesComposable()
    }
}
