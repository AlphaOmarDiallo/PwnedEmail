package com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.usecase

import com.alphaomardiallo.pawnedemail.common.data.util.DataResponse
import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity
import com.alphaomardiallo.pawnedemail.common.domain.util.ResponseD
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.model.AllBreaches
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.repository.AllBreachesHIBPRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllBreachesUseCase @Inject constructor(
    private val repository: AllBreachesHIBPRepository,
) {

    fun invoke(email: String): Flow<ResponseD<List<AllBreaches>>> = flow {
        emit(ResponseD.Loading())

        when (val result = repository.getAllBreachesHIBP(email = email)) {
            is DataResponse.Error -> emit(
                ResponseD.Error(
                    error = result.error ?: ErrorEntity.Unknown
                )
            )

            is DataResponse.Success -> emit(ResponseD.Success(data = result.data))
        }
    }
}
