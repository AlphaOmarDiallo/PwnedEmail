package com.alphaomardiallo.pawnedemail.feature.getallbreaches.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alphaomardiallo.pawnedemail.R
import com.alphaomardiallo.pawnedemail.common.presentation.theme.mediumPadding
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.validator.EmailValidator
import kotlin.reflect.KFunction1

private const val EMAIL_THRESHOLD = 2

@Composable
fun GetAllBreachesComposable() {

    val viewModel: GetAllBreachesViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    GetAllBreachesComposableContent(
        breaches = viewModel::getBreaches,
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun GetAllBreachesComposableContent(breaches: KFunction1<String, Unit>? = null) {

    Card(modifier = Modifier.fillMaxWidth()) {
        EmailSearchComposable(checkEmail = breaches)
    }
}

@Composable
private fun EmailSearchComposable(
    checkEmail: KFunction1<String, Unit>? = null,
    isLoading: Boolean = false,
) {

    var textValueEmail by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(mediumPadding()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            modifier = Modifier
                .padding(horizontal = mediumPadding())
                .fillMaxWidth(),
            value = textValueEmail,
            onValueChange = { newEmail -> textValueEmail = newEmail },
            label = { Text(text = stringResource(id = R.string.email_label)) },
            supportingText = {
                Text(
                    text = if (textValueEmail.length > EMAIL_THRESHOLD && !EmailValidator.isValidEmail(
                            textValueEmail
                        )
                    ) {
                        stringResource(id = R.string.email_supporting_text_invalid)
                    } else {
                        ""
                    },
                    color = MaterialTheme.colorScheme.error
                )
            }
        )

        if (!isLoading) {
            Button(
                onClick = { checkEmail?.invoke(textValueEmail.toLowerCase(locale = Locale.current)) },
                enabled = EmailValidator.isValidEmail(textValueEmail)
            ) {
                Text(text = stringResource(id = R.string.check_button))
            }
        } else {
            CircularProgressIndicator()
        }
    }
}
