package com.alphaomardiallo.pawnedemail.feature.secure.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun SecureComposable() {

}

@Composable
private fun SecureCard(
    drawable: Int,
    contentDescription: Int,
    text: Int,
    clickAction: (() -> Unit)? = null,
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable { clickAction?.invoke() }) {
        Row(
            modifier = Modifier.fillMaxWidth()

        ) {
            AsyncImage(
                model = drawable,
                contentDescription = stringResource(id = contentDescription),
                modifier = Modifier
                    .height(80.dp)
                    .aspectRatio(1f)
            )

            Text(text = stringResource(id = text))
        }
    }
}
