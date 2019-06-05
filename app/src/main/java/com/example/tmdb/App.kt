package com.example.tmdb

import android.app.Application
import com.example.tmdb.di.ComponentManager
import ru.s4nchez.logger.Logger

class App : Application() {

    lateinit var componentManager: ComponentManager

    override fun onCreate() {
        super.onCreate()
        if (!BuildConfig.DEBUG) {
            Logger.setEnabled(false)
        }
        componentManager = ComponentManager(this)
    }
}