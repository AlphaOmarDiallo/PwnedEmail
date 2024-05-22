package com.alphaomardiallo.pawnedemail.common.data.repository

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
class EmailRepositoryImpTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var emailDao: EmailDao

    private val email = EmailEntity(email = "x@yopmail.com")

    @Before
    fun setUp() {
        hiltRule.inject()

        // Clean email DB before each test
        emailDao.nukeEmailTable()
    }

    @After
    fun tearDown() {
        // Clean email DB before each test
        emailDao.nukeEmailTable()
    }

    @Test
    fun upsert_email_in_database() {
        runTest {
            // Given database is empty
            val firstEmail = emailDao.getFirstEmail().first()
            assertThat(firstEmail).isNull()

            // When upsert email
            emailDao.upsertEmail(email)

            // Then email is in database
            val secondEmail = emailDao.getFirstEmail().first()?.email
            assertThat(secondEmail).isEqualTo(email.email)
        }
    }

    @Test
    fun get_first_email_from_db() {
        runTest {
            // Given database is not empty
            emailDao.upsertEmail(email)

            // When get first email
            val firstEmail = emailDao.getFirstEmail().first()

            // Then email is in database
            assertThat(firstEmail?.email).isEqualTo(email.email)
        }
    }
}
