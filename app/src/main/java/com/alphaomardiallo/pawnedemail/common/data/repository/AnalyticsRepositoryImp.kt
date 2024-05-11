package com.alphaomardiallo.pawnedemail.common.data.repository

import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity
import com.alphaomardiallo.pawnedemail.common.domain.repository.AnalyticsRepository
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics
import com.google.firebase.analytics.logEvent
import javax.inject.Inject

class AnalyticsRepositoryImp @Inject constructor() : AnalyticsRepository {

    private var analytics: FirebaseAnalytics? = null

    override fun initialiseAnalytics() {
        analytics = Firebase.analytics
    }

    override fun logEventScreenView(screenName: String) {
        analytics?.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
        }
    }

    override fun logSearchEvent() {
        analytics?.logEvent(FirebaseAnalytics.Event.SEARCH) {

        }
    }

    override fun logSuccessfulSearchEvent(itemCount: Int) {
        analytics?.logEvent(FirebaseAnalytics.Event.SEARCH) {
            param(FirebaseAnalytics.Param.SUCCESS, SUCCESS)
            param(FirebaseAnalytics.Param.ITEMS, itemCount.toString())
        }
    }

    override fun logErrorSearchEvent(error: ErrorEntity) {
        analytics?.logEvent(FirebaseAnalytics.Event.SEARCH) {
            param(ERROR, ERROR)
            param(PARAM_ERROR_ENTITY, error.toString())
        }
    }

    override fun logStartLoadingAllBreaches() {
        analytics?.logEvent(EVENT_LOADING) {
            param(START, START)
        }
    }

    override fun logEndLoadingBreachesSuccessfully(itemCount: Int) {
        analytics?.logEvent(EVENT_LOADING) {
            param(END_SUC, itemCount.toString())
        }
    }

    override fun logEndLoadingBreachesError(error: ErrorEntity) {
        analytics?.logEvent(EVENT_LOADING) {
            param(END_ERR, error.toString())
        }
    }

    private companion object {
        const val EVENT_LOADING = "LOADING"

        const val PARAM_ERROR_ENTITY = "ERROR ENTITY"

        const val SUCCESS = "SUCCESS"
        const val ERROR = "ERROR"

        const val START = "START"
        const val END_SUC = "END SUCCESSFULLY"
        const val END_ERR = "END WITH ERROR"
    }
}
