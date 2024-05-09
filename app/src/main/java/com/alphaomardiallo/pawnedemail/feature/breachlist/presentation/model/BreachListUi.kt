package com.alphaomardiallo.pawnedemail.feature.breachlist.presentation.model

data class BreachListUi(
    val title: String,
    val domain: String,
    val breachDate: String,
    val description: String,
    val logoPath: String,
    val dataClasses: List<String>,
    val isMalware: Boolean,
)

fun mockBreachListObjectList() = listOf(
    BreachListUi(
        title = "instructior",
        domain = "duo",
        breachDate = "ad",
        description = "ut",
        logoPath = "appetere",
        dataClasses = listOf(),
        isMalware = false,
    ),
    BreachListUi(
        title = "instructior",
        domain = "duo",
        breachDate = "ad",
        description = "ut",
        logoPath = "appetere",
        dataClasses = listOf(),
        isMalware = false,
    ),
    BreachListUi(
        title = "instructior",
        domain = "duo",
        breachDate = "ad",
        description = "ut",
        logoPath = "appetere",
        dataClasses = listOf(),
        isMalware = false,
    )
)