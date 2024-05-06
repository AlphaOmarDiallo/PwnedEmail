package com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.validator

import java.util.regex.Pattern

object EmailValidator {

    /**
     * Regular expression pattern for validating email addresses.
     * - ^ asserts the start of the line.
     * - [a-zA-Z0-9._%+-]+ matches one or more of any alphanumeric characters, dot (.), underscore (_), percent (%),
     *   plus (+), or hyphen (-).
     * - @ matches the "@" symbol.
     * - [a-zA-Z0-9.-]+ matches one or more of any alphanumeric characters, dot (.), or hyphen (-) after the "@" symbol.
     * - \\. matches a dot (.) after the domain name.
     * - [a-zA-Z]{2,} matches two or more of any alphabetic characters for the top-level domain (TLD).
     * - $ asserts the end of the line.
     */
    private const val EMAIL_REGEX_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"

    /**
     * Checks if the provided email address is valid.
     * @param email The email address to be validated.
     * @return true if the email address is valid, false otherwise.
     */
    fun isValidEmail(email: String): Boolean {
        val pattern = Pattern.compile(EMAIL_REGEX_PATTERN)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }
}
