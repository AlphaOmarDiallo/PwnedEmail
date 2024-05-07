package com.alphaomardiallo.pawnedemail.feature.appintroduction.domain

import com.alphaomardiallo.pawnedemail.common.domain.usecase.breaches.GetBreachesCountUseCase
import javax.inject.Inject

class GetNumberBreachesUseCase @Inject constructor(
    private val getBreachesCountUseCase: GetBreachesCountUseCase,
) {

    suspend fun invoke() = getBreachesCountUseCase.invoke()
}
