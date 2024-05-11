package com.alphaomardiallo.pawnedemail.common.domain.usecase.analytics

import com.alphaomardiallo.pawnedemail.common.domain.repository.AnalyticsRepository
import javax.inject.Inject

class LogScreenViewUseCase @Inject constructor(
    private val analyticsRepository: AnalyticsRepository,
) {

    fun invoke(screenName: String) = analyticsRepository.logEventScreenView(screenName)
}
