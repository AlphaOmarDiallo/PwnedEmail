package com.alphaomardiallo.pawnedemail.feature.getallbreaches.data.remote.api

import com.alphaomardiallo.pawnedemail.common.data.util.ApiResponse
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.data.model.AllBreachesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GetAllBreachesHIBPApi {

    @GET(BASE_URL)
    suspend fun getAllBreachesHIBP(
        @Query("account") emailAddress: String
    ): ApiResponse<AllBreachesDto>

    private companion object {
        const val BASE_URL = "breachedaccount/"
    }
}
