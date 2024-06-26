package com.alphaomardiallo.pawnedemail.feature.breachesregistered.domain.repository

import com.alphaomardiallo.pawnedemail.common.data.util.DataResponse
import com.alphaomardiallo.pawnedemail.feature.breachesregistered.domain.model.BreachesRegistered

interface AllBreachesRegisteredRepository {

    suspend fun getAllBreachesRegisteredRepository(): DataResponse<List<BreachesRegistered>>
}
