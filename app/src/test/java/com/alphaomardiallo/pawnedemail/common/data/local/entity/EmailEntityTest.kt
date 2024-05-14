package com.alphaomardiallo.pawnedemail.common.data.local.entity

import com.alphaomardiallo.pawnedemail.common.domain.model.Email
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class EmailEntityTest {

    private val emailEntity = EmailEntity(id = 0, email = "x@yopmail.com")

    @Test
    fun `ItemEmailEntity can be transformed to Email`() {
        val toEmail = emailEntity.toEmail()
        assertThat(toEmail).isInstanceOf(Email::class.java)
    }

    @Test
    fun `ItemEmailEntity when transformed to Email has the same data`() {
        val toEmail = emailEntity.toEmail()
        assertThat(emailEntity.email).isEqualTo(toEmail.email)
    }
}
