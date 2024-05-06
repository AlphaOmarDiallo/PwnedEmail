package com.alphaomardiallo.pawnedemail.feature.getallbreaches.data.remote.api

import com.alphaomardiallo.pawnedemail.common.data.util.ApiResponse
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.data.model.BreachesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetAllBreachesHIBPApi {

    /**
     * Getting all breaches for an account with the [HIBP API](https://haveibeenpwned.com/API/v3)
     * If the account is found in a breach, it will return HTTP200 response with a body.
     * If the account is not found in a breach, it will return HTTP404 showing it could not be found.
     */
    @GET("breachedaccount/{account}")
    suspend fun getAllBreachesHIBP(
        @Path("account") emailAddress: String,
        @Query("truncateResponse") truncateResponse: Boolean = false
    ): ApiResponse<List<BreachesDto>>
}
