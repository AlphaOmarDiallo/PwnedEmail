package com.alphaomardiallo.pawnedemail.feature.breachesregistered.data.remote.api

import com.alphaomardiallo.pawnedemail.common.data.util.ApiResponse
import com.alphaomardiallo.pawnedemail.feature.breachesregistered.data.model.AllBreachesDto
import retrofit2.http.GET

interface GetAllBreachesRegisteredApi {

    @GET("breaches")
    suspend fun getAllBreaches(): ApiResponse<List<AllBreachesDto>>
}