package com.alphaomardiallo.pawnedemail.common.domain.usecase.breaches

import com.alphaomardiallo.pawnedemail.common.domain.model.Breach
import com.alphaomardiallo.pawnedemail.common.domain.repository.BreachRepository
import javax.inject.Inject

class UpsertBreachUseCase @Inject constructor(
    private val breachRepository: BreachRepository,
) {

    suspend fun invoke(breach: Breach) = breachRepository.upsertBreach(breach.toBreachEntity())
}
