package com.alphaomardiallo.pawnedemail.feature.getallbreaches.presentation.model

data class GetAlBreachesUiState(
    val breaches: List<BreachesUi> = emptyList(),
    val isLoading: Boolean = false,
    val email: String = "",
)
