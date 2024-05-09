package com.alphaomardiallo.pawnedemail.feature.breachlist.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.alphaomardiallo.pawnedemail.R
import com.alphaomardiallo.pawnedemail.common.presentation.mainactivity.composable.LinkedText
import com.alphaomardiallo.pawnedemail.common.presentation.theme.mediumPadding
import com.alphaomardiallo.pawnedemail.common.presentation.theme.smallPadding
import com.alphaomardiallo.pawnedemail.common.presentation.theme.xSmallPadding
import com.alphaomardiallo.pawnedemail.feature.breachlist.presentation.model.BreachListUi
import com.alphaomardiallo.pawnedemail.feature.breachlist.presentation.model.mockBreachListObjectList

@Composable
fun BreachListComposable() {

    val viewModel: BreachesListViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    if (!uiState.value.lastEmailUsed.isNullOrBlank()) {
        BreachListContent(
            list = uiState.value.breaches,
            email = uiState.value.lastEmailUsed
        )
    }
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
        BreachList(list = list)
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

@Preview
@Composable
private fun BreachList(list: List<BreachListUi> = mockBreachListObjectList()) {
    Column {
        list.forEach { breach ->
            BreachCard(breachListUi = breach)
        }
    }
}

@Composable
private fun BreachCard(breachListUi: BreachListUi) {

    val context = LocalContext.current
    val descriptionHTML = HtmlCompat.fromHtml(breachListUi.description, 0).toString()
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier.padding(xSmallPadding()),
            shape = RectangleShape,
            colors = CardDefaults.cardColors().copy(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier.padding(end = smallPadding()),
                        colors = CardDefaults.cardColors().copy(
                            containerColor = MaterialTheme.colorScheme.surfaceDim,
                        )
                    ) {
                        AsyncImage(
                            model = breachListUi.logoPath,
                            contentDescription = stringResource(id = R.string.logo_description),
                            modifier = Modifier
                                .padding(xSmallPadding())
                                .height(50.dp)
                                .aspectRatio(1f)
                        )
                    }

                    Column {
                        Text(
                            text = breachListUi.title,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = stringResource(id = R.string.date),
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(text = breachListUi.breachDate)
                        }
                    }

                }

                Image(
                    imageVector = if (!expanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                    contentDescription = if (!expanded) Icons.Default.KeyboardArrowDown.name else Icons.Default.KeyboardArrowUp.name,
                    modifier = Modifier
                        .clickable { expanded = !expanded }
                )
            }
            CardSpacer()

            if (breachListUi.isMalware) {
                Text(
                    text = stringResource(id = R.string.malware_breach),
                    style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.error)
                )
                CardSpacer()
            }

            AnimatedVisibility(visible = expanded) {
                Column {
                    Text(
                        text = stringResource(id = R.string.leaked_data),
                        style = MaterialTheme.typography.titleMedium
                    )
                    LeakedDataList(list = breachListUi.dataClasses)
                    CardSpacer()

                    Text(
                        text = stringResource(id = R.string.description),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(text = descriptionHTML)
                    if (breachListUi.domain.isNotBlank()) {
                        CardSpacer()
                        LinkedText(breachListUi.domain, context)
                    }
                }
            }
        }

        HorizontalDivider()
    }
}

@Composable
private fun LeakedDataList(list: List<String>) {
    val chunkSize = list.size / 2
    val chunks = list.chunked(chunkSize)
    val symbol = "•"

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Top
    ) {
        Column(modifier = Modifier.weight(1f)) {
            chunks.first().forEach { leakedData ->
                Text(text = "$symbol $leakedData")
            }
        }
        Column {
            chunks.getOrNull(1)?.forEach { leakedData ->
                Text(text = "$symbol $leakedData")
            }
        }
    }
}

@Composable
private fun CardSpacer() = Spacer(modifier = Modifier.height(xSmallPadding()))
