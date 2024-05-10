package com.alphaomardiallo.pawnedemail.common.domain.util

import com.alphaomardiallo.pawnedemail.R
import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity

fun getErrorMessage(error: ErrorEntity?) = when (error) {
    ErrorEntity.AccessDenied -> R.string.error_access_denied
    ErrorEntity.BadRequest -> R.string.error_bad_request
    ErrorEntity.Network -> R.string.error_network
    ErrorEntity.NotAllowed -> R.string.error_not_allowed
    ErrorEntity.NotFound -> R.string.error_not_found
    ErrorEntity.ServerError -> R.string.error_server_error
    ErrorEntity.ServiceUnavailable -> R.string.error_server_error
    ErrorEntity.Unauthorized -> R.string.error_unauthorized
    ErrorEntity.Unknown -> R.string.error_unknown
    ErrorEntity.TooManyRequest -> R.string.error_too_many_request
    else -> R.string.error_unknown
}
