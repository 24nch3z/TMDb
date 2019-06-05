package com.example.tmdb.di

import com.example.tmdb.executor.AppSchedulersProvider
import com.example.tmdb.executor.SchedulersProvider
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
class SchedulerModule {

    @Provides
    @Singleton
    fun provideSchedulersProvider(): SchedulersProvider {
        return AppSchedulersProvider(Schedulers.io(), AndroidSchedulers.mainThread())
    }
}