package com.alphaomardiallo.pawnedemail.feature.getallbreaches.presentation.model

import androidx.annotation.StringRes

data class GetAlBreachesUiState(
    val breaches: List<BreachesUi> = emptyList(),
    val isLoading: Boolean = false,
    val email: String = "",
    val isError: Boolean = false,
    @StringRes val errorMessage: Int? = null,
    val isNotBreached: Boolean = false,
)
