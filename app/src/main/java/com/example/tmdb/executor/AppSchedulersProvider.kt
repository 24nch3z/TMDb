package com.example.tmdb.executor

import io.reactivex.Scheduler

class AppSchedulersProvider(
        private val ioScheduler: Scheduler,
        private val uiScheduler: Scheduler
) : SchedulersProvider {

    override fun io() = ioScheduler

    override fun ui() = uiScheduler
}