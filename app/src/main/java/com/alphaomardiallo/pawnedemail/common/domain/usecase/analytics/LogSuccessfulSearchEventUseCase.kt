package com.alphaomardiallo.pawnedemail.common.domain.usecase.analytics

import com.alphaomardiallo.pawnedemail.common.domain.repository.AnalyticsRepository
import javax.inject.Inject

class LogSuccessfulSearchEventUseCase @Inject constructor(
    private val analyticsRepository: AnalyticsRepository,
) {

    fun invoke(itemCount: Int) = analyticsRepository.logSuccessfulSearchEvent(itemCount)
}
