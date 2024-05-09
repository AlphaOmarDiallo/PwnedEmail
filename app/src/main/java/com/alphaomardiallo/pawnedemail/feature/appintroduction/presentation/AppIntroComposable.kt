package com.alphaomardiallo.pawnedemail.feature.appintroduction.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.alphaomardiallo.pawnedemail.R
import com.alphaomardiallo.pawnedemail.common.presentation.theme.smallPadding

@Composable
fun AppIntroComposable() {
    AppIntroComposableContent()
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun AppIntroComposableContent() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.intro_subtitle),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = smallPadding()),
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.secondary
            ),
            textAlign = TextAlign.Justify
        )

        Text(
            text = stringResource(id = R.string.intro_definition),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = smallPadding()),
            style = MaterialTheme.typography.labelSmall.copy(
                color = MaterialTheme.colorScheme.tertiary,
                fontStyle = FontStyle.Italic
            )
        )

        AsyncImage(
            model = R.drawable.safa_data_img,
            contentDescription = stringResource(id = R.string.image_content_description),
        )
    }
}
