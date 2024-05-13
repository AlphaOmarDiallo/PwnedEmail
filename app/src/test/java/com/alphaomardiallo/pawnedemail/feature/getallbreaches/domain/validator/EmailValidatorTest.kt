package com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.validator

import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.validator.EmailValidator.isValidEmail
import com.google.common.truth.Truth.assertThat
import org.junit.Test


class EmailValidatorTest {

    @Test
    fun `These emails must return true`() {
        assertThat(isValidEmail(CORRECT_EMAIL_1)).isTrue()
        assertThat(isValidEmail(CORRECT_EMAIL_2)).isTrue()
        assertThat(isValidEmail(CORRECT_EMAIL_3)).isTrue()
    }

    @Test
    fun `This email without @ should return false`() {
        assertThat(isValidEmail(INCORRECT_EMAIL_1)).isFalse()
    }

    @Test
    fun `This email with only one character for tld should return false`() {
        assertThat(isValidEmail(INCORRECT_EMAIL_2)).isFalse()
    }

    @Test
    fun `This email without tld should not work`() {
        assertThat(isValidEmail(INCORRECT_EMAIL_3)).isFalse()
    }

    private companion object {
        const val CORRECT_EMAIL_1 = "x@yopmail.com"
        const val CORRECT_EMAIL_2 = "x@y.fr"
        const val CORRECT_EMAIL_3 = "x.d@y.f.fr"
        const val INCORRECT_EMAIL_1 = "x.yopmail.com"
        const val INCORRECT_EMAIL_2 = "x@yopmail.c"
        const val INCORRECT_EMAIL_3 = "x@y"
    }
}
