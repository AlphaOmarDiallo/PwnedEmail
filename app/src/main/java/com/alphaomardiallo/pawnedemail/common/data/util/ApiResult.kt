package com.alphaomardiallo.pawnedemail.common.data.util

import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity

sealed class ApiResult<T>(val data: T? = null, val error: ErrorEntity? = null) {
    class Success<T>(data: T?) : ApiResult<T>(data)
    class Error<T>(error: ErrorEntity, data: T? = null) : ApiResult<T>(data, error)
}
