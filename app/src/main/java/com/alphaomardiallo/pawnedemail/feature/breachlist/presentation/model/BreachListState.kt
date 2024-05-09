package com.alphaomardiallo.pawnedemail.feature.breachlist.presentation.model

data class BreachListState(
    val breaches: List<BreachListUi> = emptyList(),
    val lastEmailUsed: String? = null,
)
