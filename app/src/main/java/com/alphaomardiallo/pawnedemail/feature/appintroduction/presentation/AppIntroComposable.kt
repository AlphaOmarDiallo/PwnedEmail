package com.alphaomardiallo.pawnedemail.feature.appintroduction.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alphaomardiallo.pawnedemail.R
import com.alphaomardiallo.pawnedemail.common.presentation.theme.mediumPadding

@Composable
fun AppIntroComposable() {

    val viewModel: AppIntroViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    AppIntroComposableContent(breachNumber = uiState.value.breachNumber)
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun AppIntroComposableContent(breachNumber: Int = 2) {

    val text = if (breachNumber == 0) {
        stringResource(id = R.string.intro_title)
    } else {
        String.format(stringResource(id = R.string.intro_title_breaches), breachNumber)
    }

    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(mediumPadding()),
        style = MaterialTheme.typography.titleMedium,
        textAlign = TextAlign.Center
    )
}
