package com.alphaomardiallo.pawnedemail.feature.allbreaches.data.repository

import com.alphaomardiallo.pawnedemail.common.data.util.ApiResult
import com.alphaomardiallo.pawnedemail.common.data.util.DataResponse
import com.alphaomardiallo.pawnedemail.feature.allbreaches.data.remote.datasource.AllBreachesRegisteredDataSource
import com.alphaomardiallo.pawnedemail.feature.allbreaches.domain.model.BreachesRegistered
import com.alphaomardiallo.pawnedemail.feature.allbreaches.domain.repository.AllBreachesRegisteredRepository
import javax.inject.Inject

class AllBreachesRegisteredRepositoryImp @Inject constructor(
    private val remoteDataSource: AllBreachesRegisteredDataSource,
) : AllBreachesRegisteredRepository {

    override suspend fun getAllBreachesRegisteredRepository(): DataResponse<List<BreachesRegistered>> {
        return when (val result = remoteDataSource.getAllBreachesRegistered()) {
            is ApiResult.Error -> DataResponse.Error(error = result.error, data = result.data)
            is ApiResult.Success -> DataResponse.Success(data = result.data)
        }
    }
}
