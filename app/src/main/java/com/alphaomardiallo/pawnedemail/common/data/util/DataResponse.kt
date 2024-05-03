package com.alphaomardiallo.pawnedemail.common.data.util

import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity

sealed class DataResponse<T>(val data: T? = null, val error: ErrorEntity? = null) {
    class Success<T>(data: T?) : DataResponse<T>(data)
    class Error<T>(error: ErrorEntity?, data: T? = null) : DataResponse<T>(data, error)
}
