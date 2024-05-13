package com.alphaomardiallo.pawnedemail.common.data.local.entity

import com.alphaomardiallo.pawnedemail.common.domain.model.Breach
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class BreachesEntityTest {

    val itemBreachEntity = BreachesEntity(
        id = 6982,
        name = "Lucien Beard",
        title = "fabulas",
        domain = "rutrum",
        breachDate = "accumsan",
        addedDate = "has",
        modifiedDate = "tincidunt",
        pwnCount = 9750,
        description = "non",
        logoPath = "dictumst",
        dataClasses = listOf(),
        isVerified = false,
        isFabricated = false,
        isSensitive = false,
        isRetired = false,
        isSpamList = false,
        isMalware = false,
        isSubscriptionFree = false
    )

    @Test
    fun `ItemBreachEntity can be transformed to Breach`() {
        val itemBreach = itemBreachEntity.toBreach()

        assertThat(itemBreach).isInstanceOf(Breach::class.java)
    }

    @Test
    fun `ItemBreachEntity when transformed to breach has the same data`() {
        val itemBreach = itemBreachEntity.toBreach()

        assertThat(itemBreach.name).isEqualTo(itemBreachEntity.name)
        assertThat(itemBreach.title).isEqualTo(itemBreachEntity.title)
        assertThat(itemBreach.domain).isEqualTo(itemBreachEntity.domain)
        assertThat(itemBreach.breachDate).isEqualTo(itemBreachEntity.breachDate)
        assertThat(itemBreach.addedDate).isEqualTo(itemBreachEntity.addedDate)
        assertThat(itemBreach.modifiedDate).isEqualTo(itemBreachEntity.modifiedDate)
        assertThat(itemBreach.pwnCount).isEqualTo(itemBreachEntity.pwnCount)
        assertThat(itemBreach.description).isEqualTo(itemBreachEntity.description)
        assertThat(itemBreach.logoPath).isEqualTo(itemBreachEntity.logoPath)
        assertThat(itemBreach.dataClasses).isEqualTo(itemBreachEntity.dataClasses)
        assertThat(itemBreach.isVerified).isEqualTo(itemBreachEntity.isVerified)
        assertThat(itemBreach.isFabricated).isEqualTo(itemBreachEntity.isFabricated)
        assertThat(itemBreach.isSensitive).isEqualTo(itemBreachEntity.isSensitive)
        assertThat(itemBreach.isRetired).isEqualTo(itemBreachEntity.isRetired)
        assertThat(itemBreach.isSpamList).isEqualTo(itemBreachEntity.isSpamList)
        assertThat(itemBreach.isMalware).isEqualTo(itemBreachEntity.isMalware)
        assertThat(itemBreach.isSubscriptionFree).isEqualTo(itemBreachEntity.isSubscriptionFree)
    }
}
