package com.alphaomardiallo.pawnedemail.common.data.util

import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity
import org.junit.Assert
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ApiResultTest {

    // Test the data property
    @Test
    fun `data property returns data for Success`() {
        val data = "some data"
        val apiSuccess = ApiResult.Success(data)
        Assert.assertEquals(data, apiSuccess.data)
    }

    @Test
    fun `data property returns null for Error`() {
        val apiError = ApiResult.Error<String>(ErrorEntity.Unknown)
        Assert.assertNull(apiError.data)
    }

    // Test the error property
    @Test
    fun `error property returns error for Error`() {
        val errorEntity = ErrorEntity.Unknown
        val apiError = ApiResult.Error<String>(errorEntity)
        assertEquals(errorEntity, apiError.error)
    }

    @Test
    fun `error property returns null for Success`() {
        val apiSuccess = ApiResult.Success("some data")
        Assert.assertNull(apiSuccess.error)
    }
}
