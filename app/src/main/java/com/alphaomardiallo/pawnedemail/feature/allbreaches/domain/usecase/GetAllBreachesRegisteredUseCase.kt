package com.alphaomardiallo.pawnedemail.feature.allbreaches.domain.usecase

import com.alphaomardiallo.pawnedemail.feature.allbreaches.domain.repository.AllBreachesRegisteredRepository
import javax.inject.Inject

class GetAllBreachesRegisteredUseCase @Inject constructor(
    private val allBreachesRegisteredRepository: AllBreachesRegisteredRepository,
) {

    suspend fun invoke() = allBreachesRegisteredRepository.getAllBreachesRegisteredRepository()
}
