package com.alphaomardiallo.pawnedemail

import android.app.Application
import com.alphaomardiallo.pawnedemail.common.domain.usecase.analytics.InitAnalyticsUseCase
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import timber.log.Timber
import timber.log.Timber.Forest.plant

@HiltAndroidApp
class PawnedEmailApplication : Application() {

    @Inject
    lateinit var initAnalyticsUseCase: InitAnalyticsUseCase

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            plant(Timber.DebugTree())
        }

        initAnalyticsUseCase.invoke()
    }
}
