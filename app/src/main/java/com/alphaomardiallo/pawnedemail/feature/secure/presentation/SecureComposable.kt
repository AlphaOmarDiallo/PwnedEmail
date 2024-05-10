package com.alphaomardiallo.pawnedemail.feature.secure.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alphaomardiallo.pawnedemail.R
import com.alphaomardiallo.pawnedemail.common.presentation.theme.largePadding
import com.alphaomardiallo.pawnedemail.common.presentation.theme.mediumPadding
import com.alphaomardiallo.pawnedemail.common.presentation.theme.xSmallPadding
import com.alphaomardiallo.pawnedemail.feature.secure.domain.SecureSteps

@Preview
@Composable
fun SecureComposable() {

    val list = listOf(SecureSteps.Password, SecureSteps.TwoFactorAuth)

    Column(
        modifier = Modifier
            .padding(largePadding())
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {

        AsyncImage(
            model = R.drawable.secure_data_img,
            contentDescription = stringResource(id = R.string.secure_image_content_description)
        )

        Spacer(modifier = Modifier.height(mediumPadding()))

        list.forEach {
            SecureCard(step = it)
            Spacer(modifier = Modifier.height(mediumPadding()))
        }
    }
}

@Composable
private fun SecureCard(
    step: SecureSteps,
    clickAction: (() -> Unit)? = null,
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable { clickAction?.invoke() }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = mediumPadding()),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = step.image,
                contentDescription = stringResource(id = step.contentDescription),
                modifier = Modifier
                    .padding(xSmallPadding())
                    .height(80.dp)
                    .aspectRatio(1f)
            )
            Text(
                text = stringResource(id = step.title),
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Black)
            )
        }
        Text(
            text = stringResource(id = step.text),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(mediumPadding())
        )
    }
}
