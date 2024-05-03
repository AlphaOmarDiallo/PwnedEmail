package com.alphaomardiallo.pawnedemail.feature.getallbreaches.data.remote.api

import com.alphaomardiallo.pawnedemail.common.data.util.ApiResponse
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.data.model.AllBreachesDto
import retrofit2.http.GET
import retrofit2.http.Path

interface GetAllBreachesHIBPApi {
    /**
     * Getting all breaches for an account with the [HIBP API](https://haveibeenpwned.com/API/v3)
     * If the account is found in a breach, it will return HTTP200 response with a body.
     * If the account is not found in a breach, it will return HTTP404 showing it could not be found.
     */
    @GET("$BASE_URL{account}")
    suspend fun getAllBreachesHIBP(
        @Path("account") emailAddress: String,
    ): ApiResponse<AllBreachesDto>

    private companion object {
        const val BASE_URL = "breachedaccount/"
    }
}
