package com.alphaomardiallo.pawnedemail.common.domain.util

import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity

sealed class ResponseD<T>(val data: T? = null, val error: ErrorEntity? = null) {
    class Success<T>(data: T?) : ResponseD<T>(data)
    class Error<T>(data: T? = null, error: ErrorEntity = ErrorEntity.Unknown) :
        ResponseD<T>(data, error)

    class Loading<T>(data: T? = null) : ResponseD<T>(data)
}
