package com.alphaomardiallo.pawnedemail.feature.getallbreaches.domain.usecase

import com.alphaomardiallo.pawnedemail.common.domain.model.Breach
import com.alphaomardiallo.pawnedemail.common.domain.usecase.breaches.UpsertBreachUseCase
import javax.inject.Inject

class SaveBreachesUseCase @Inject constructor(
    private val upsertBreachUseCase: UpsertBreachUseCase,
) {

    suspend fun invoke(breach: Breach) = upsertBreachUseCase.invoke(breach)
}
