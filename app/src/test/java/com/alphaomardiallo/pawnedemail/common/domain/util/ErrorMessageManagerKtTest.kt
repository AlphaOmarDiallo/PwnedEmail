package com.alphaomardiallo.pawnedemail.common.domain.util

import com.alphaomardiallo.pawnedemail.R
import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ErrorMessageManagerKtTest {

    @Test
    fun `getErrorMessage() returns the correct error message for each ErrorEntity type`() {
        // Test each ErrorEntity type
        assertThat(getErrorMessage(ErrorEntity.AccessDenied)).isEqualTo(R.string.error_access_denied)
        assertThat(getErrorMessage(ErrorEntity.BadRequest)).isEqualTo(R.string.error_bad_request)
        assertThat(getErrorMessage(ErrorEntity.Network)).isEqualTo(R.string.error_network)
        assertThat(getErrorMessage(ErrorEntity.NotAllowed)).isEqualTo(R.string.error_not_allowed)
        assertThat(getErrorMessage(ErrorEntity.NotFound)).isEqualTo(R.string.error_not_found)
        assertThat(getErrorMessage(ErrorEntity.ServerError)).isEqualTo(R.string.error_server_error)
        assertThat(getErrorMessage(ErrorEntity.ServiceUnavailable)).isEqualTo(R.string.error_server_error)
        assertThat(getErrorMessage(ErrorEntity.Unauthorized)).isEqualTo(R.string.error_unauthorized)
        assertThat(getErrorMessage(ErrorEntity.Unknown)).isEqualTo(R.string.error_unknown)
        assertThat(getErrorMessage(ErrorEntity.TooManyRequest)).isEqualTo(R.string.error_too_many_request)

        // Test a null ErrorEntity
        assertThat(getErrorMessage(null)).isEqualTo(R.string.error_unknown)
    }
}
