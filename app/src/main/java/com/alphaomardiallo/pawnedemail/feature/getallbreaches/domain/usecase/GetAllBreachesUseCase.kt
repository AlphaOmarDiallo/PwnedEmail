package com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.usecase

import com.alphaomardiallo.pawnedemail.common.data.util.DataResponse
import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity
import com.alphaomardiallo.pawnedemail.common.domain.util.ResponseD
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.data.remote.api.GetAllBreachesHIBPApi.Companion.URL_BREACHED_ACCOUNT
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.repository.AllBreachesHIBPRepository
import com.alphaomardiallo.pawnedemail.feature.getallbreaches.presentation.model.BreachesUi
import com.google.firebase.perf.FirebasePerformance
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllBreachesUseCase @Inject constructor(
    private val repository: AllBreachesHIBPRepository,
) {

    fun invoke(email: String): Flow<ResponseD<List<BreachesUi>>> = flow {
        emit(ResponseD.Loading())

        val trace = FirebasePerformance.getInstance().newTrace(URL_BREACHED_ACCOUNT)
        trace.start()

        when (val result = repository.getAllBreachesHIBP(email = email)) {
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
                val breachesUiList = result.data?.map { breaches -> breaches.toBreachesUi() }
                emit(ResponseD.Success(data = breachesUiList))
            }
        }
    }
}
