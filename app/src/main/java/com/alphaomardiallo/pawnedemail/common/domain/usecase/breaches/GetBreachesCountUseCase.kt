package com.alphaomardiallo.pawnedemail.common.domain.usecase.breaches

import com.alphaomardiallo.pawnedemail.common.domain.repository.BreachRepository
import javax.inject.Inject

class GetBreachesCountUseCase @Inject constructor(
    private val breachRepository: BreachRepository,
) {

    suspend fun invoke() = breachRepository.getCount()
}
