package com.alphaomardiallo.pawnedemail.feature.appintroduction

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.alphaomardiallo.pawnedemail.R
import com.alphaomardiallo.pawnedemail.common.presentation.theme.mediumPadding

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AppIntroComposable() {
    Text(
        text = stringResource(id = R.string.intro_title),
        modifier = Modifier
            .fillMaxWidth()
            .padding(mediumPadding()),
        style = MaterialTheme.typography.titleMedium,
        textAlign = TextAlign.Center
    )
}