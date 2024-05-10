package com.alphaomardiallo.pawnedemail.common.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.alphaomardiallo.pawnedemail.R

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainAppBar() {
    Column(modifier = Modifier.fillMaxWidth()) {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.intro_title),
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.SemiBold)
                )
            },
            /*actions = {
                IconButton(onClick = { Timber.i("ACTIONNNNNN") }) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = Icons.Default.Info.name
                    )
                }
            }*/
        )
        HorizontalDivider(color = MaterialTheme.colorScheme.primary)
    }
}
