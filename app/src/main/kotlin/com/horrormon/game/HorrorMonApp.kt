package com.horrormon.game

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HorrorMonApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
