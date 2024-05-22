package com.alphaomardiallo.pawnedemail.common.data.local

import com.alphaomardiallo.pawnedemail.TestUtil.provideBreachEntityList
import com.alphaomardiallo.pawnedemail.common.data.local.dao.BreachesDao
import com.alphaomardiallo.pawnedemail.common.data.local.dao.EmailDao
import com.alphaomardiallo.pawnedemail.common.data.local.entity.EmailEntity
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
class BreachesDatabaseTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var database: BreachesDatabase

    @Inject
    lateinit var breachesDao: BreachesDao

    @Inject
    lateinit var emailDao: EmailDao

    @Before
    fun init() {
        hiltRule.inject()

        // Clean DB before each test
        breachesDao.nukeBreachesTable()
        emailDao.nukeEmailTable()
    }

    @After
    fun tearDown() {
        // Clean DB after each test
        breachesDao.nukeBreachesTable()
        emailDao.nukeEmailTable()
    }

    @Test
    fun test_that_when_a_list_of_breaches_is_added_to_empty_db_they_have_the_same_size() {
        runTest {
            // Given Api fetches a list of breaches
            val listBreach = provideBreachEntityList()
            var listBreachInDb = breachesDao.getAllBreaches().first()
            assertThat(listBreachInDb.size).isEqualTo(EMPTY_DB)

            // When I add these bridges to the DB
            listBreach.map { breach ->
                breachesDao.upsertBreach(breach)
            }

            // The Database has the same number of items in the list
            listBreachInDb = breachesDao.getAllBreaches().first()
            assertThat(listBreachInDb.size).isEqualTo(listBreach.size)
        }
    }

    @Test
    fun test_that_when_items_are_added_to_db_they_are_in_the_db() {
        runTest {
            // Given Api fetches a list of breaches
            val listBreach = provideBreachEntityList()
            var listBreachInDb = breachesDao.getAllBreaches().first()
            assertThat(listBreachInDb.size).isEqualTo(EMPTY_DB)

            // When I add these bridges to the DB
            listBreach.map { breach ->
                breachesDao.upsertBreach(breach)
            }

            // The Database has the items inside.
            var listIndex = FIRST_ITEM_INDEX
            listBreachInDb = breachesDao.getAllBreaches().first()

            listBreachInDb.map { breachInDb ->
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
    fun test_that_when_a_list_of_breaches_is_added_to_empty_db_the_count_request_is_correct() {
        runTest {
            // Given Api fetches a list of breaches
            val listBreach = provideBreachEntityList()
            assertThat(breachesDao.getCount().first()).isEqualTo(EMPTY_DB)

            // When I add these breaches to the DB
            listBreach.map { breach ->
                breachesDao.upsertBreach(breach)
            }

            // The method count returns the correct number of items
            assertThat(breachesDao.getCount().first()).isEqualTo(listBreach.size)
        }
    }

    @Test
    fun test_that_when_an_email_is_added_in_an_empty_db_it_is_added() {
        runTest {
            // Given the user provides an email
            val email = EmailEntity(email = "xyz@yopmail.com")
            assertThat(emailDao.getFirstEmail().first()).isNull()

            // When I add it to the DB
            emailDao.upsertEmail(email)

            // The email is in the db
            assertThat(emailDao.getFirstEmail().first()?.email).isEqualTo(email.email)
        }
    }

    private companion object {
        const val EMPTY_DB = 0
        const val FIRST_ITEM_INDEX = 0
    }
}
