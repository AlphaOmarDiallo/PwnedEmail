package com.alphaomardiallo.pawnedemail.feature.getallbreaches.data.remote.datasource

import com.alphaomardiallo.pawnedemail.common.data.remote.BaseRemoteDataSource
import com.alphaomardiallo.pawnedemail.common.data.util.ApiResponse
import com.alphaomardiallo.pawnedemail.common.data.util.ApiResult
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.data.remote.api.GetAllBreachesHIBPApi
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.model.Breaches
import javax.inject.Inject

class AllBreachesDataSource @Inject constructor(
    private val api: GetAllBreachesHIBPApi,
) : BaseRemoteDataSource() {

    suspend fun getAllBreaches(email: String): ApiResult<List<Breaches>> {
        return when (val result = api.getAllBreachesHIBP(emailAddress = email)) {
            is ApiResponse.ApiError -> ApiResult.Error(getErrorEntity(result.errorCode))
            is ApiResponse.ApiException -> ApiResult.Error(result.errorEntity)
            is ApiResponse.ApiSuccess -> ApiResult.Success(result.data.map { it.toBreaches() })
        }
    }
}
