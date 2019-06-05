package com.example.tmdb.di

import android.content.Context

class ComponentManager(private val context: Context) {

    val dagger: AppComponent = buildAppComponent()

    private fun buildAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(context))
                .netModule(NetModule())
                .schedulerModule(SchedulerModule())
                .build()
    }
}