package com.alphaomardiallo.pawnedemail.common.data.remote

import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity
import java.net.HttpURLConnection
import okhttp3.ResponseBody

abstract class BaseRemoteDataSource {
    open fun getErrorEntity(code: Int, errorBody: ResponseBody? = null): ErrorEntity {
        return when (code) {
            // 400 : HTTP_BAD_REQUEST
            HttpURLConnection.HTTP_BAD_REQUEST -> ErrorEntity.BadRequest
            // 401 : HTTP_UNAUTHORIZED
            HttpURLConnection.HTTP_UNAUTHORIZED -> ErrorEntity.Unauthorized
            // 403 : HTTP_FORBIDDEN
            HttpURLConnection.HTTP_FORBIDDEN -> ErrorEntity.AccessDenied
            // 404 : HTTP_NOT_FOUND
            HttpURLConnection.HTTP_NOT_FOUND -> ErrorEntity.NotFound
            // 405 : HTTP_BAD_METHOD
            HttpURLConnection.HTTP_BAD_METHOD -> ErrorEntity.NotAllowed
            // 429 : HTTP_TOO_MANY_REQUEST
            HTTP_TOO_MANY_REQUEST -> ErrorEntity.TooManyRequest
            // 500: HTTP_SERVER_ERROR/HTTP_INTERNAL_ERROR
            HttpURLConnection.HTTP_INTERNAL_ERROR -> ErrorEntity.ServerError
            // 503 : HTTP_UNAVAILABLE
            HttpURLConnection.HTTP_UNAVAILABLE -> ErrorEntity.ServiceUnavailable
            else -> ErrorEntity.Unknown
        }
    }

    private companion object {
        private const val HTTP_TOO_MANY_REQUEST = 429
    }
}
