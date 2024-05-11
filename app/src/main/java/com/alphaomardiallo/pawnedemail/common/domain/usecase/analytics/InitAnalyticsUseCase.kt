package com.alphaomardiallo.pawnedemail.common.domain.usecase.analytics

import com.alphaomardiallo.pawnedemail.common.domain.repository.AnalyticsRepository
import javax.inject.Inject

class InitAnalyticsUseCase @Inject constructor(
    private val analyticsRepository: AnalyticsRepository,
) {

    fun invoke() = analyticsRepository.initialiseAnalytics()
}
