package com.alphaomardiallo.pawnedemail.common.presentation.mainactivity.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun MainScaffold(
    content: @Composable (PaddingValues) -> Unit,
) {

    Scaffold(
        topBar = { MainTopBar() }
    ) { paddingValues ->
        content(paddingValues)
    }
}
