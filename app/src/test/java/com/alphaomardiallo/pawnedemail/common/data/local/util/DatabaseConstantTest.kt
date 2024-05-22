package com.alphaomardiallo.pawnedemail.common.data.local.util

import com.alphaomardiallo.pawnedemail.common.data.local.util.DatabaseConstant.BREACHES_DB_NAME
import com.alphaomardiallo.pawnedemail.common.data.local.util.DatabaseConstant.BREACHES_ENTITY_NAME
import com.alphaomardiallo.pawnedemail.common.data.local.util.DatabaseConstant.EMAIL_ENTITY_NAME
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class DatabaseConstantTest {

    @Test
    fun `test that database constants are defined`() {
        assertThat(BREACHES_DB_NAME).isEqualTo("breaches_database")
        assertThat(BREACHES_ENTITY_NAME).isEqualTo("breaches_table")
        assertThat(EMAIL_ENTITY_NAME).isEqualTo("email_table")
    }
}
