package com.alphaomardiallo.pawnedemail.common.domain.usecase.breaches

import com.alphaomardiallo.pawnedemail.common.domain.repository.BreachRepository
import javax.inject.Inject

class DeleteAllBreachesUseCase @Inject constructor(
    private val breachRepository: BreachRepository,
) {

    fun invoke() = breachRepository.deleteAllBreaches()
}
