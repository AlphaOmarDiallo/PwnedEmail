package com.alphaomardiallo.pawnedemail.feature.breachesregistered.presentation.model

data class BreachesRegisteredState(
    val breaches: List<BreachesRegisteredUi> = emptyList(),
    val isLoading: Boolean = false,
)
