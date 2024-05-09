package com.alphaomardiallo.pawnedemail.screens.breaches

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alphaomardiallo.pawnedemail.common.presentation.theme.largePadding
import com.alphaomardiallo.pawnedemail.feature.breachesregistered.presentation.AllBreachesComposable

@Composable
fun BreachesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(largePadding())
    ) {
        AllBreachesComposable()
    }
}
