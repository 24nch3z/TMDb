package com.example.tmdb.executor

import java.util.concurrent.Executor

class AppExecutorsProvider(
        private val io: Executor,
        private val ui: Executor
) : ExecutorsProvider {

    override fun io() = io

    override fun ui() = ui
}