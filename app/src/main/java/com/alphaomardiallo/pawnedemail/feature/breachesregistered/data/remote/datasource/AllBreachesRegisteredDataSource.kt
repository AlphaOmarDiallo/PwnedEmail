package com.alphaomardiallo.pawnedemail.feature.breachesregistered.data.remote.datasource

import com.alphaomardiallo.pawnedemail.common.data.remote.BaseRemoteDataSource
import com.alphaomardiallo.pawnedemail.common.data.util.ApiResponse
import com.alphaomardiallo.pawnedemail.common.data.util.ApiResult
import com.alphaomardiallo.pawnedemail.feature.breachesregistered.data.remote.api.GetAllBreachesRegisteredApi
import com.alphaomardiallo.pawnedemail.feature.breachesregistered.domain.model.BreachesRegistered
import javax.inject.Inject

class AllBreachesRegisteredDataSource @Inject constructor(
    private val api: GetAllBreachesRegisteredApi,
) : BaseRemoteDataSource() {

    suspend fun getAllBreachesRegistered(): ApiResult<List<BreachesRegistered>> {
        return when (val result = api.getAllBreaches()) {
            is ApiResponse.ApiError -> ApiResult.Error(getErrorEntity(result.errorCode))
            is ApiResponse.ApiException -> ApiResult.Error(result.errorEntity)
            is ApiResponse.ApiSuccess -> ApiResult.Success(result.data.map { it.toBreachesRegistered() })
        }
    }
}
