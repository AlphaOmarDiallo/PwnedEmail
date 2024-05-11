package com.alphaomardiallo.pawnedemail.common.domain.usecase.analytics

import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity
import com.alphaomardiallo.pawnedemail.common.domain.repository.AnalyticsRepository
import javax.inject.Inject

class LogErrorSearchEventUseCase @Inject constructor(
    private val analyticsRepository: AnalyticsRepository,
) {

    fun invoke(error: ErrorEntity) = analyticsRepository.logErrorSearchEvent(error)
}
