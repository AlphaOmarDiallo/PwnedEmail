package com.alphaomardiallo.pawnedemail.feature.breachesregistered.domain.usecase

import com.alphaomardiallo.pawnedemail.common.data.util.DataResponse
import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity
import com.alphaomardiallo.pawnedemail.common.domain.util.ResponseD
import com.alphaomardiallo.pawnedemail.feature.breachesregistered.data.remote.api.GetAllBreachesRegisteredApi.Companion.BASE_URL_ALL_BREACHES
import com.alphaomardiallo.pawnedemail.feature.breachesregistered.domain.repository.AllBreachesRegisteredRepository
import com.alphaomardiallo.pawnedemail.feature.breachesregistered.presentation.model.BreachesRegisteredUi
import com.google.firebase.perf.FirebasePerformance
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllBreachesRegisteredUseCase @Inject constructor(
    private val allBreachesRegisteredRepository: AllBreachesRegisteredRepository,
) {
    private val trace = FirebasePerformance.getInstance().newTrace(BASE_URL_ALL_BREACHES)

    suspend fun invoke(): Flow<ResponseD<List<BreachesRegisteredUi>>> = flow {
        emit(ResponseD.Loading())

        trace.start()

        when (val result = allBreachesRegisteredRepository.getAllBreachesRegisteredRepository()) {
            is DataResponse.Error -> {
                trace.stop()
                emit(
                    ResponseD.Error(
                        error = result.error ?: ErrorEntity.Unknown
                    )
                )
            }

            is DataResponse.Success -> {
                trace.stop()
                val breachesRegisteredUiList =
                    result.data?.map { breachRegistered -> breachRegistered.toBreachesRegisteredUi() }
                        ?.sortedByDescending { it.breachDate }
                emit(ResponseD.Success(data = breachesRegisteredUiList))
            }
        }
    }
}
