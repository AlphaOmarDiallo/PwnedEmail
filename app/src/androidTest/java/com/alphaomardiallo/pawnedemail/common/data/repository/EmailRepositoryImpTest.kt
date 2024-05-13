package com.alphaomardiallo.pawnedemail.common.data.repository

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class EmailRepositoryImpTest {

    @Rule
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun upsertEmail() {
    }

    @Test
    fun getFirstEmail() {
    }
}