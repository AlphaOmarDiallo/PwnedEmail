package com.alphaomardiallo.pawnedemail.feature.breachesregistered.domain.usecase

import com.alphaomardiallo.pawnedemail.common.data.util.DataResponse
import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity
import com.alphaomardiallo.pawnedemail.common.domain.util.ResponseD
import com.alphaomardiallo.pawnedemail.feature.breachesregistered.domain.repository.AllBreachesRegisteredRepository
import com.alphaomardiallo.pawnedemail.feature.breachesregistered.presentation.model.BreachesRegisteredUi
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllBreachesRegisteredUseCase @Inject constructor(
    private val allBreachesRegisteredRepository: AllBreachesRegisteredRepository,
) {

    suspend fun invoke(): Flow<ResponseD<List<BreachesRegisteredUi>>> = flow {
        emit(ResponseD.Loading())

        when (val result = allBreachesRegisteredRepository.getAllBreachesRegisteredRepository()) {
            is DataResponse.Error -> emit(
                ResponseD.Error(
                    error = result.error ?: ErrorEntity.Unknown
                )
            )

            is DataResponse.Success -> {
                val breachesRegisteredUiList =
                    result.data?.map { breachRegistered -> breachRegistered.toBreachesRegisteredUi() }
                        ?.sortedByDescending { it.breachDate }
                emit(ResponseD.Success(data = breachesRegisteredUiList))
            }
        }
    }
}
