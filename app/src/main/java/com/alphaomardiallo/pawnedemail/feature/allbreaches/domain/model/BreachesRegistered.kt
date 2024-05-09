package com.alphaomardiallo.pawnedemail.feature.allbreaches.domain.model

data class BreachesRegistered(
    val addedDate: String,
    val breachDate: String,
    val dataClasses: List<String>,
    val description: String,
    val domain: String,
    val isFabricated: Boolean,
    val isMalware: Boolean,
    val isRetired: Boolean,
    val isSensitive: Boolean,
    val isSpamList: Boolean,
    val isSubscriptionFree: Boolean,
    val isVerified: Boolean,
    val logoPath: String,
    val modifiedDate: String,
    val name: String,
    val pwnCount: Int,
    val title: String,
)
