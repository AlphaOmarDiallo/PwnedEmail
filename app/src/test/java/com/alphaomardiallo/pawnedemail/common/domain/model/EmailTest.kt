package com.alphaomardiallo.pawnedemail.common.domain.model

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class EmailTest {
    @Test
    fun `toEmailEntity() converts Email to EmailEntity correctly`() {
        // Create an Email object
        val email = Email("test@example.com")

        // Convert it to an EmailEntity object
        val emailEntity = email.toEmailEntity()

        // Assert that the fields are converted correctly
        assertEquals(1, emailEntity.id)
        assertEquals(email.email, emailEntity.email)
    }
}
