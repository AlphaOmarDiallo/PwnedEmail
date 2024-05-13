package com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.validator

import java.util.regex.Pattern

object EmailValidator {

    /**
     * Regex pattern for validating email addresses
     * Explanation:
     * ^                   // Start of the string
     * [a-zA-Z0-9._%+-]+   // Match one or more of the following characters: letters (both cases), numbers, dot, underscore, percent, plus, or hyphen
     * @                   // Match the "@" symbol
     * [a-zA-Z0-9.-]+      // Match one or more of the following characters: letters (both cases), numbers, dot, or hyphen
     * \.                  // Match a literal dot (.)
     * [a-zA-Z]{2,}        // Match two or more letters (both cases)
     * $                   // End of the string
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
