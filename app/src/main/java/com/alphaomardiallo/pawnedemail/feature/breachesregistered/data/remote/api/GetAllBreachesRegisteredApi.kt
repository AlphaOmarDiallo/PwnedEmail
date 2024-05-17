package com.alphaomardiallo.pawnedemail.feature.breachesregistered.data.remote.api

import com.alphaomardiallo.pawnedemail.common.data.util.ApiResponse
import com.alphaomardiallo.pawnedemail.feature.breachesregistered.data.model.AllBreachesDto
import retrofit2.http.GET

interface GetAllBreachesRegisteredApi {

    @GET(BASE_URL_ALL_BREACHES)
    suspend fun getAllBreaches(): ApiResponse<List<AllBreachesDto>>

    companion object {
        const val BASE_URL_ALL_BREACHES = "breaches"
    }
}
