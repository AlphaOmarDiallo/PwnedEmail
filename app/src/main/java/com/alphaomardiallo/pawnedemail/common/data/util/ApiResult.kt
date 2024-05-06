package com.alphaomardiallo.pawnedemail.common.data.util

import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity

/**
 * Sealed class representing the result of an API call.
 * @param T The type of data returned in the result.
 * @property data The data returned in the result, if any.
 * @property error The error entity representing any error that occurred during the API call, if any.
 */
sealed class ApiResult<T>(val data: T? = null, val error: ErrorEntity? = null) {

    /**
     * Represents a successful API call result.
     * @param data The data returned in the result, if any.
     */
    class Success<T>(data: T?) : ApiResult<T>(data)

    /**
     * Represents an API call result with an error.
     * @param error The error entity representing the error that occurred during the API call.
     * @param data The data returned in the result, if any.
     */
    class Error<T>(error: ErrorEntity, data: T? = null) : ApiResult<T>(data, error)
}
