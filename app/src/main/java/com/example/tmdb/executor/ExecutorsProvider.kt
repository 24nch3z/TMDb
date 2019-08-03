package com.example.tmdb.executor

import java.util.concurrent.Executor

interface ExecutorsProvider {
    fun io(): Executor
    fun ui(): Executor
}