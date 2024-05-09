package com.alphaomardiallo.pawnedemail.feature.breachlist.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.tooling.preview.Preview
import com.alphaomardiallo.pawnedemail.R
import com.alphaomardiallo.pawnedemail.common.presentation.theme.mediumPadding

@Composable
fun BreachListComposable() {
    BreachListContent()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun BreachListContent() {

    Column(modifier = Modifier.fillMaxWidth()) {
        ListTitle()
        HorizontalDivider()
    }
}

@Composable
private fun ListTitle() {
    val quantity = 0
    val text = String.format(
        pluralStringResource(
            id = R.plurals.breach_found,
            count = quantity
        ),
        quantity,
        "alpha"
    )

    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium.copy(color = if (quantity > 0) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary),
        modifier = Modifier.padding(mediumPadding())
    )
}
