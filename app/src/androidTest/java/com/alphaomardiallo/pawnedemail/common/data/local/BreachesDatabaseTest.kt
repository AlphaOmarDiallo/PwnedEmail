package com.alphaomardiallo.pawnedemail.common.data.local

import com.alphaomardiallo.pawnedemail.common.data.local.dao.BreachesDao
import com.alphaomardiallo.pawnedemail.common.data.local.dao.EmailDao
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import javax.inject.Inject
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
    }

    @Test
    fun classes_injected_with_success() {
        assertThat(database).isNotNull()
        assertThat(breachesDao).isNotNull()
        assertThat(emailDao).isNotNull()
    }
}
