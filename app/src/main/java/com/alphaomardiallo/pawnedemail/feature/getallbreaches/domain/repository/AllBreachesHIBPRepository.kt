package com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.repository

import com.alphaomardiallo.pawnedemail.common.data.util.DataResponse
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.model.AllBreaches

interface AllBreachesHIBPRepository {

    suspend fun getAllBreachesHIBP(email: String): DataResponse<List<AllBreaches>>
}
