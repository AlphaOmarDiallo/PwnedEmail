package com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.model

import com.alphaomardiallo.pawnedemail.feature.getallbreaches.presentation.model.BreachesUi

data class Breaches(
    val name: String,
    val title: String,
    val domain: String,
    val breachDate: String,
    val addedDate: String,
    val modifiedDate: String,
    val pwnCount: Long,
    val description: String,
    val logoPath: String,
    val dataClasses: List<String>,
    val isVerified: Boolean,
    val isFabricated: Boolean,
    val isSensitive: Boolean,
    val isRetired: Boolean,
    val isSpamList: Boolean,
    val isMalware: Boolean,
    val isSubscriptionFree: Boolean,
) {
    fun toBreachesUi() = BreachesUi(
        name = this.name,
        title = this.title,
        domain = this.domain,
        breachDate = this.breachDate,
        addedDate = this.addedDate,
        modifiedDate = this.modifiedDate,
        pwnCount = this.pwnCount,
        description = this.description,
        logoPath = this.description,
        dataClasses = this.dataClasses,
        isVerified = this.isVerified,
        isFabricated = this.isFabricated,
        isSensitive = this.isSensitive,
        isRetired = this.isRetired,
        isSpamList = this.isSpamList,
        isMalware = this.isMalware,
        isSubscriptionFree = this.isSubscriptionFree,
    )
}