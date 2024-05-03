package com.alphaomardiallo.pawnedemail

import android.app.Application
import com.squareup.leakcanary.core.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.Forest.plant

@HiltAndroidApp
class PawnedEmailApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG){
            plant(Timber.DebugTree())
        }
    }
}
