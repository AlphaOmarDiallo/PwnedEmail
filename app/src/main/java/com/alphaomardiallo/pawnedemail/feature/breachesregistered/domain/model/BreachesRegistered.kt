package com.alphaomardiallo.pawnedemail.feature.breachesregistered.domain.model

import com.alphaomardiallo.pawnedemail.feature.breachesregistered.presentation.model.BreachesRegisteredUi

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
) {
    fun toBreachesRegisteredUi() = BreachesRegisteredUi(
        addedDate = this.addedDate,
        breachDate = this.breachDate,
        dataClasses = this.dataClasses,
        description = this.description,
        domain = this.domain,
        isFabricated = this.isFabricated,
        isMalware = this.isMalware,
        isRetired = this.isRetired,
        isSensitive = this.isSensitive,
        isSpamList = this.isSpamList,
        isSubscriptionFree = this.isSubscriptionFree,
        isVerified = this.isVerified,
        logoPath = this.logoPath,
        modifiedDate = this.modifiedDate,
        name = this.name,
        pwnCount = this.pwnCount,
        title = this.title
    )
}
