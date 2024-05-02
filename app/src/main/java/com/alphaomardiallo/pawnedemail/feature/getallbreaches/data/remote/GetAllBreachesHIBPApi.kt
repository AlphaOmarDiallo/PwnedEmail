package com.alphaomardiallo.pawnedemail.feature.getallbreaches.data.remote

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

interface GetAllBreachesHIBPApi {

    @FormUrlEncoded
    @GET(BASE_URL)
    suspend fun getAllBreachesHIBP(
        @Field("account") emailAddress: String
    )

    private companion object{
        const val BASE_URL = "breachedaccount/"
    }
}
