package com.alphaomardiallo.pawnedemail.feature.breachlist.domain.usecase


import com.alphaomardiallo.pawnedemail.common.domain.usecase.breaches.GetAllBreachesUseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.flow

class GetListOfBreaches @Inject constructor(
    private val getAllBreachesUseCase: GetAllBreachesUseCase,
) {

    suspend fun invoke() = flow {
        getAllBreachesUseCase.invoke().collect { breachList ->
            emit(breachList.map { it.toBreachUi() })
        }
    }
}
