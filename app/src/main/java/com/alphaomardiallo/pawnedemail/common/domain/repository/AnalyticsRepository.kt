package com.alphaomardiallo.pawnedemail.common.domain.repository

import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity

interface AnalyticsRepository {

    fun initialiseAnalytics()

    fun logEventScreenView(screenName: String)

    fun logSearchEvent()

    fun logSuccessfulSearchEvent(itemCount: Int)

    fun logErrorSearchEvent(error: ErrorEntity)

    fun logStartLoadingAllBreaches()

    fun logEndLoadingBreachesSuccessfully(itemCount: Int)

    fun logEndLoadingBreachesError(error: ErrorEntity)
}
