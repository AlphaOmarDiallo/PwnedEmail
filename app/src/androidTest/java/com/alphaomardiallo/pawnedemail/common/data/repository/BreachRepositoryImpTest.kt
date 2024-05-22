package com.alphaomardiallo.pawnedemail.common.data.repository

import com.alphaomardiallo.pawnedemail.TestUtil
import com.alphaomardiallo.pawnedemail.common.data.local.dao.BreachesDao
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import javax.inject.Inject
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class BreachRepositoryImpTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var breachesDao: BreachesDao

    private val listBreach = TestUtil.provideBreachEntityList()

    @Before
    fun setUp() {
        hiltRule.inject()

        // Clean email DB before each test
        breachesDao.nukeBreachesTable()
    }

    @After
    fun tearDown() {
        // Clean email DB before each test
        breachesDao.nukeBreachesTable()
    }

    @Test
    fun upsert_breach_in_db() {
        runTest {
            // Given a list of breach to add in db
            addListBreach()

            // The Database has the items inside.
            var listIndex = FIRST_ITEM_INDEX

            listBreach.map { breachInDb ->
                assertThat(breachInDb.name).isEqualTo(listBreach[listIndex].name)
                assertThat(breachInDb.title).isEqualTo(listBreach[listIndex].title)
                assertThat(breachInDb.domain).isEqualTo(listBreach[listIndex].domain)
                assertThat(breachInDb.breachDate).isEqualTo(listBreach[listIndex].breachDate)
                assertThat(breachInDb.addedDate).isEqualTo(listBreach[listIndex].addedDate)
                assertThat(breachInDb.modifiedDate).isEqualTo(listBreach[listIndex].modifiedDate)
                assertThat(breachInDb.description).isEqualTo(listBreach[listIndex].description)
                assertThat(breachInDb.logoPath).isEqualTo(listBreach[listIndex].logoPath)
                assertThat(breachInDb.dataClasses).isEqualTo(listBreach[listIndex].dataClasses)
                assertThat(breachInDb.isVerified).isEqualTo(listBreach[listIndex].isVerified)
                assertThat(breachInDb.isFabricated).isEqualTo(listBreach[listIndex].isFabricated)
                assertThat(breachInDb.isSensitive).isEqualTo(listBreach[listIndex].isSensitive)
                assertThat(breachInDb.isRetired).isEqualTo(listBreach[listIndex].isRetired)
                assertThat(breachInDb.isSpamList).isEqualTo(listBreach[listIndex].isSpamList)
                assertThat(breachInDb.isMalware).isEqualTo(listBreach[listIndex].isMalware)
                assertThat(breachInDb.isSubscriptionFree).isEqualTo(listBreach[listIndex].isSubscriptionFree)

                listIndex++
            }
        }
    }

    @Test
    fun delete_all_breaches_in_db() {
        runTest {
            // Given a list of breach to add in db
            addListBreach()

            // Delete all items in db
            breachesDao.nukeBreachesTable()

            // The Database has no items inside.
            assertThat(breachesDao.getAllBreaches().first().isEmpty()).isTrue()
        }
    }

    @Test
    fun get_all_breaches_in_db() {
        runTest {
            // Given a list of breach to add in db
            addListBreach()

            // The Database has the items inside.
            var listIndex = FIRST_ITEM_INDEX

            listBreach.map { breachInDb ->
                assertThat(breachInDb.name).isEqualTo(listBreach[listIndex].name)
                assertThat(breachInDb.title).isEqualTo(listBreach[listIndex].title)
                assertThat(breachInDb.domain).isEqualTo(listBreach[listIndex].domain)
                assertThat(breachInDb.breachDate).isEqualTo(listBreach[listIndex].breachDate)
                assertThat(breachInDb.addedDate).isEqualTo(listBreach[listIndex].addedDate)
                assertThat(breachInDb.modifiedDate).isEqualTo(listBreach[listIndex].modifiedDate)
                assertThat(breachInDb.description).isEqualTo(listBreach[listIndex].description)
                assertThat(breachInDb.logoPath).isEqualTo(listBreach[listIndex].logoPath)
                assertThat(breachInDb.dataClasses).isEqualTo(listBreach[listIndex].dataClasses)
                assertThat(breachInDb.isVerified).isEqualTo(listBreach[listIndex].isVerified)
                assertThat(breachInDb.isFabricated).isEqualTo(listBreach[listIndex].isFabricated)
                assertThat(breachInDb.isSensitive).isEqualTo(listBreach[listIndex].isSensitive)
                assertThat(breachInDb.isRetired).isEqualTo(listBreach[listIndex].isRetired)
                assertThat(breachInDb.isSpamList).isEqualTo(listBreach[listIndex].isSpamList)
                assertThat(breachInDb.isMalware).isEqualTo(listBreach[listIndex].isMalware)
                assertThat(breachInDb.isSubscriptionFree).isEqualTo(listBreach[listIndex].isSubscriptionFree)

                listIndex++
            }

            // The number of items in db is equal to the number of items in list
            assertThat(breachesDao.getAllBreaches().first().size).isEqualTo(listBreach.size)
        }

    }

    @Test
    fun get_count_of_breaches_in_db() {
        runTest {
            // Given a list of breach to add in db
            addListBreach()

            // The number of items in db is equal to the number of items in list
            assertThat(breachesDao.getAllBreaches().first().size).isEqualTo(listBreach.size)
        }
    }

    private suspend fun addListBreach() {
        listBreach.forEach {
            breachesDao.upsertBreach(it)
        }
    }

    private companion object {
        const val FIRST_ITEM_INDEX = 0
    }
}
