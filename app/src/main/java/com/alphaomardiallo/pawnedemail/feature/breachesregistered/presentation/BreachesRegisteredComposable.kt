package com.alphaomardiallo.pawnedemail.feature.breachesregistered.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.alphaomardiallo.pawnedemail.R
import com.alphaomardiallo.pawnedemail.common.presentation.composable.DotsFlashingLoader
import com.alphaomardiallo.pawnedemail.common.presentation.composable.LinkedText
import com.alphaomardiallo.pawnedemail.common.presentation.theme.greenHighlight
import com.alphaomardiallo.pawnedemail.common.presentation.theme.largePadding
import com.alphaomardiallo.pawnedemail.common.presentation.theme.smallPadding
import com.alphaomardiallo.pawnedemail.common.presentation.theme.xSmallPadding
import com.alphaomardiallo.pawnedemail.feature.breachesregistered.presentation.model.BreachesRegisteredUi

@Composable
fun AllBreachesComposable() {

    val viewModel: BreachesRegisteredViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    var listFullyDisplayed by remember { mutableStateOf(false) }

    val setListFullyDisplayed: (Boolean) -> Unit = { value ->
        listFullyDisplayed = value
    }

    AllBreachesContent(
        list = uiState.value.breaches,
        isLoading = uiState.value.isLoading,
        listDisplayed = listFullyDisplayed,
        onListFullyDisplayed = setListFullyDisplayed
    )
}

@Composable
private fun AllBreachesContent(
    list: List<BreachesRegisteredUi> = emptyList(),
    isLoading: Boolean = false,
    listDisplayed: Boolean = false,
    onListFullyDisplayed: (Boolean) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading || !listDisplayed) {
            AsyncImage(
                model = R.drawable.loading_data_img,
                contentDescription = stringResource(id = R.string.image_loading_content_description)
            )
            Spacer(modifier = Modifier.height(largePadding()))
            Text(
                text = stringResource(id = R.string.loading),
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Black)
            )
            Spacer(modifier = Modifier.height(largePadding()))
            DotsFlashingLoader()
        }

        BreachList(
            list = list,
            onListFullyDisplayed = onListFullyDisplayed
        )
    }
}

@Composable
private fun BreachList(
    list: List<BreachesRegisteredUi> = emptyList(),
    onListFullyDisplayed: (Boolean) -> Unit,
) {
    LazyColumn {
        items(list) { breach ->
            BreachCard(breach = breach)
        }

        onListFullyDisplayed.invoke(true)
    }
}

@Composable
private fun BreachCard(breach: BreachesRegisteredUi) {

    val context = LocalContext.current
    val descriptionHTML = HtmlCompat.fromHtml(breach.description, 0).toString()
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
                            model = breach.logoPath,
                            contentDescription = stringResource(id = R.string.logo_description),
                            modifier = Modifier
                                .padding(xSmallPadding())
                                .height(50.dp)
                                .aspectRatio(1f)
                        )
                    }

                    Column {
                        Text(
                            text = breach.title,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = stringResource(id = R.string.date),
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(text = breach.breachDate)
                        }
                    }

                }

                Image(
                    imageVector = if (!expanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                    contentDescription = if (!expanded) Icons.Default.KeyboardArrowDown.name else Icons.Default.KeyboardArrowUp.name,
                    modifier = Modifier.clickable { expanded = !expanded },
                    colorFilter = ColorFilter.tint(greenHighlight)
                )
            }
            CardSpacer()

            if (breach.pwnCount > 0) {
                Text(
                    text = String.format(stringResource(id = R.string.count), breach.pwnCount),
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
                    LeakedDataList(list = breach.dataClasses)
                    CardSpacer()

                    Text(
                        text = stringResource(id = R.string.description),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(text = descriptionHTML)
                    if (breach.domain.isNotBlank()) {
                        CardSpacer()
                        LinkedText(breach.domain, context)
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
