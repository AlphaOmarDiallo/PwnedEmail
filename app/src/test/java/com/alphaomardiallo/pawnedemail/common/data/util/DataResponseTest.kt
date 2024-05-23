package com.alphaomardiallo.pawnedemail.common.data.util

import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull

class DataResponseTest {

    // Test the data property
    @Test
    fun `data property returns data for Success`() {
        val data = "some data"
        val dataResponseSuccess = DataResponse.Success(data)
        assertEquals(data, dataResponseSuccess.data)
    }

    @Test
    fun `data property returns null for Error`() {
        val dataResponseError = DataResponse.Error<String>(ErrorEntity.Unknown)
        assertNull(dataResponseError.data)
    }

    // Test the error property
    @Test
    fun `error property returns error for Error`() {
        val errorEntity = ErrorEntity.Unknown
        val dataResponseError = DataResponse.Error<String>(errorEntity)
        assertEquals(errorEntity, dataResponseError.error)
    }

    @Test
    fun `error property returns null for Success`() {
        val dataResponseSuccess = DataResponse.Success("some data")
        assertNull(dataResponseSuccess.error)
    }
}
