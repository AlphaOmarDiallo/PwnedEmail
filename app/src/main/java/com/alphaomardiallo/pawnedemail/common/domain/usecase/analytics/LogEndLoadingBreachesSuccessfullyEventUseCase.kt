package com.alphaomardiallo.pawnedemail.common.domain.usecase.analytics

import com.alphaomardiallo.pawnedemail.common.domain.repository.AnalyticsRepository
import javax.inject.Inject

class LogEndLoadingBreachesSuccessfullyEventUseCase @Inject constructor(
    private val analyticsRepository: AnalyticsRepository,
) {

    fun invoke(itemCount: Int) = analyticsRepository.logEndLoadingBreachesSuccessfully(itemCount)
}
