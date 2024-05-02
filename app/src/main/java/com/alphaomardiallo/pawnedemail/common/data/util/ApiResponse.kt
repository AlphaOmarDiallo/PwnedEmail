package com.alphaomardiallo.pawnedemail.common.data.util

import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity
import java.io.InvalidObjectException
import okhttp3.ResponseBody

sealed class ApiResponse<T> {

    ///////////////////////////////////////////////////////////////////////////
    // DATA
    ///////////////////////////////////////////////////////////////////////////

    open val errorCode: Int = 0

    open val errorBody: ResponseBody? = null

    open val errorEntity: ErrorEntity = ErrorEntity.Unknown

    open val data: T
        get() = throw InvalidObjectException("No data value for $this resource")

    open val dataOrNull: T? = null

    ///////////////////////////////////////////////////////////////////////////
    // CLASS
    ///////////////////////////////////////////////////////////////////////////

    class ApiSuccess<T>(private val internalData: T) : ApiResponse<T>() {
        override val data: T
            get() = internalData
    }

    class ApiError<T>(
        private val internalErrorCode: Int,
        private val interErrorBody: ResponseBody?,
    ) : ApiResponse<T>() {
        override val errorCode: Int
            get() = internalErrorCode
        override val errorBody: ResponseBody?
            get() = interErrorBody
    }

    class ApiException<T>(private val throwableErrorEntity: ErrorEntity) : ApiResponse<T>() {
        override val errorEntity: ErrorEntity
            get() = throwableErrorEntity
    }
}
