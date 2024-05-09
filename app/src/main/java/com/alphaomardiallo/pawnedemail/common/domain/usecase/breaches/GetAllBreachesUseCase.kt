package com.alphaomardiallo.pawnedemail.common.domain.usecase.breaches

import com.alphaomardiallo.pawnedemail.common.domain.repository.BreachRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.flow

class GetAllBreachesUseCase @Inject constructor(
    private val breachRepository: BreachRepository,
) {

    suspend fun invoke() = flow {
        breachRepository.getAllBreaches().collect { breachList ->
            emit(breachList.map { it.toBreach() })
        }
    }
}
