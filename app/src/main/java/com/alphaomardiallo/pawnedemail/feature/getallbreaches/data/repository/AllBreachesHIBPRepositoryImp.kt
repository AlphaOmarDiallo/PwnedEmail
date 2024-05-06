package com.alphaomardiallo.pawnedemail.feature.getallbreaches.data.repository

import com.alphaomardiallo.pawnedemail.common.data.util.ApiResult
import com.alphaomardiallo.pawnedemail.common.data.util.DataResponse
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.data.remote.datasource.AllBreachesDataSource
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.model.Breaches
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.repository.AllBreachesHIBPRepository
import javax.inject.Inject

class AllBreachesHIBPRepositoryImp @Inject constructor(
    private val remoteDataSource: AllBreachesDataSource,
) : AllBreachesHIBPRepository {

    override suspend fun getAllBreachesHIBP(email: String): DataResponse<List<Breaches>> {
        return when (val result = remoteDataSource.getAllBreaches(email = email)) {
            is ApiResult.Error -> DataResponse.Success(data = result.data)
            is ApiResult.Success -> DataResponse.Error(error = result.error, data = result.data)
        }
    }
}
