package com.alphaomardiallo.pawnedemail.common.domain.model

import org.junit.Assert.assertEquals
import org.junit.Test

class BreachTest {

    @Test
    fun `toBreachEntity() converts Breach to BreachesEntity correctly`() {
        // Create a Breach object
        val breach = Breach(
            name = "Test Breach",
            title = "Test Breach Title",
            domain = "test.com",
            breachDate = "2023-01-01",
            addedDate = "2023-01-02",
            modifiedDate = "2023-01-03",
            pwnCount = 1000,
            description = "This is a test breach.",
            logoPath = "https://example.com/logo.png",
            dataClasses = listOf("passwords", "email addresses"),
            isVerified = true,
            isFabricated = false,
            isSensitive = true,
            isRetired = false,
            isSpamList = false,
            isMalware = true,
            isSubscriptionFree = true
        )

        // Convert it to a BreachesEntity object
        val breachesEntity = breach.toBreachEntity()

        // Assert that the fields are converted correctly
        assertEquals(breach.name, breachesEntity.name)
        assertEquals(breach.title, breachesEntity.title)
        assertEquals(breach.domain, breachesEntity.domain)
        assertEquals(breach.breachDate, breachesEntity.breachDate)
        assertEquals(breach.addedDate, breachesEntity.addedDate)
        assertEquals(breach.modifiedDate, breachesEntity.modifiedDate)
        assertEquals(breach.pwnCount, breachesEntity.pwnCount)
        assertEquals(breach.description, breachesEntity.description)
        assertEquals(breach.logoPath, breachesEntity.logoPath)
        assertEquals(breach.dataClasses, breachesEntity.dataClasses)
        assertEquals(breach.isVerified, breachesEntity.isVerified)
        assertEquals(breach.isFabricated, breachesEntity.isFabricated)
        assertEquals(breach.isSensitive, breachesEntity.isSensitive)
        assertEquals(breach.isRetired, breachesEntity.isRetired)
        assertEquals(breach.isSpamList, breachesEntity.isSpamList)
        assertEquals(breach.isMalware, breachesEntity.isMalware)
        assertEquals(breach.isSubscriptionFree, breachesEntity.isSubscriptionFree)
    }

    @Test
    fun `toBreachUi() converts Breach to BreachListUi correctly`() {
        // Create a Breach object
        val breach = Breach(
            name = "Test Breach",
            title = "Test Breach Title",
            domain = "test.com",
            breachDate = "2023-01-01",
            addedDate = "2023-01-02",
            modifiedDate = "2023-01-03",
            pwnCount = 1000,
            description = "This is a test breach.",
            logoPath = "https://example.com/logo.png",
            dataClasses = listOf("passwords", "email addresses"),
            isVerified = true,
            isFabricated = false,
            isSensitive = true,
            isRetired = false,
            isSpamList = false,
            isMalware = true,
            isSubscriptionFree = true
        )

        // Convert it to a BreachListUi object
        val breachListUi = breach.toBreachUi()

        // Assert that the fields are converted correctly
        assertEquals(breach.title, breachListUi.title)
        assertEquals(breach.domain, breachListUi.domain)
        assertEquals(breach.breachDate, breachListUi.breachDate)
        assertEquals(breach.description, breachListUi.description)
        assertEquals(breach.logoPath, breachListUi.logoPath)
        assertEquals(breach.dataClasses, breachListUi.dataClasses)
        assertEquals(breach.isMalware, breachListUi.isMalware)
    }
}
