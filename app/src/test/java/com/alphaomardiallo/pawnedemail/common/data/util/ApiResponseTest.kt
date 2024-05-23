package com.alphaomardiallo.pawnedemail.common.data.util

import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity
import io.mockk.mockk
import java.io.InvalidObjectException
import okhttp3.ResponseBody
import org.junit.Assert
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows

class ApiResponseTest {

    // Test the data property
    @Test
    fun `data property returns internalData for ApiSuccess`() {
        val data = "some data"
        val apiSuccess = ApiResponse.ApiSuccess(data)
        assertEquals(data, apiSuccess.data)
    }

    @Test
    fun `data property throws exception for ApiError`() {
        val apiError = ApiResponse.ApiError<String>(404, null)
        assertThrows<InvalidObjectException> { apiError.data }
    }

    @Test
    fun `data property throws exception for ApiException`() {
        val apiException = ApiResponse.ApiException<String>(ErrorEntity.Unknown)
        assertThrows<InvalidObjectException> { apiException.data }
    }

    // Test the errorCode property
    @Test
    fun `errorCode property returns internalErrorCode for ApiError`() {
        val errorCode = 404
        val apiError = ApiResponse.ApiError<String>(errorCode, null)
        assertEquals(errorCode, apiError.errorCode)
    }

    @Test
    fun `errorCode property returns 0 for ApiSuccess`() {
        val apiSuccess = ApiResponse.ApiSuccess("some data")
        assertEquals(0, apiSuccess.errorCode)
    }

    @Test
    fun `errorCode property returns 0 for ApiException`() {
        val apiException = ApiResponse.ApiException<String>(ErrorEntity.Unknown)
        assertEquals(0, apiException.errorCode)
    }

    // Test the errorBody property
    @Test
    fun `errorBody property returns interErrorBody for ApiError`() {
        val errorBody = mockk<ResponseBody>()
        val apiError = ApiResponse.ApiError<String>(404, errorBody)
        assertEquals(errorBody, apiError.errorBody)
    }

    @Test
    fun `errorBody property returns null for ApiSuccess`() {
        val apiSuccess = ApiResponse.ApiSuccess("some data")
        Assert.assertNull(apiSuccess.errorBody)
    }

    @Test
    fun `errorBody property returns null for ApiException`() {
        val apiException = ApiResponse.ApiException<String>(ErrorEntity.Unknown)
        Assert.assertNull(apiException.errorBody)
    }

    // Test the errorEntity property
    @Test
    fun `errorEntity property returns throwableErrorEntity for ApiException`() {
        val errorEntity = ErrorEntity.Unknown
        val apiException = ApiResponse.ApiException<String>(errorEntity)
        assertEquals(errorEntity, apiException.errorEntity)
    }

    @Test
    fun `errorEntity property returns ErrorEntity Unknown for ApiError`() {
        val apiError = ApiResponse.ApiError<String>(404, null)
        assertEquals(ErrorEntity.Unknown, apiError.errorEntity)
    }

    @Test
    fun `errorEntity property returns ErrorEntity Unknown for ApiSuccess`() {
        val apiSuccess = ApiResponse.ApiSuccess("some data")
        assertEquals(ErrorEntity.Unknown, apiSuccess.errorEntity)
    }
}
