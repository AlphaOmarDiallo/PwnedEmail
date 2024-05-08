package com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.usecase

import com.alphaomardiallo.pawnedemail.common.domain.usecase.breaches.DeleteAllBreachesUseCase
import javax.inject.Inject

class EmptyBreachesUseCase @Inject constructor(
    private val deleteAllBreachesUseCase: DeleteAllBreachesUseCase,
) {

    suspend fun invoke() = deleteAllBreachesUseCase.invoke()
}
