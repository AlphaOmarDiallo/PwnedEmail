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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alphaomardiallo.pawnedemail.R
import com.alphaomardiallo.pawnedemail.common.presentation.theme.mediumPadding
import com.alphaomardiallo.pawnedemail.feature.breachlist.presentation.model.BreachListUi

@Composable
fun BreachListComposable() {

    val viewModel: BreachesListViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    BreachListContent(
        list = uiState.value.breaches,
        email = uiState.value.lastEmailUsed
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun BreachListContent(
    list: List<BreachListUi> = emptyList(),
    email: String? = null,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        ListTitle(
            quantity = list.size,
            email = email
        )
        HorizontalDivider()
    }
}

@Composable
private fun ListTitle(quantity: Int = 0, email: String? = null) {
    val text = if (email.isNullOrBlank()) {
        stringResource(id = R.string.no_breach_found)
    } else {
        String.format(
            pluralStringResource(
                id = R.plurals.breach_found,
                count = quantity
            ),
            quantity,
            email
        )
    }

    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium.copy(color = if (quantity > 0) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary),
        modifier = Modifier.padding(mediumPadding())
    )
}

@Composable
private fun BreachList(list: List<BreachListUi> = emptyList()) {

}
