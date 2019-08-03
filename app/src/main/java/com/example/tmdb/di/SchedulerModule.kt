package com.example.tmdb.di

import com.example.tmdb.executor.*
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class SchedulerModule {

    @Provides
    @Singleton
    fun provideSchedulersProvider(): SchedulersProvider {
        return AppSchedulersProvider(Schedulers.io(), AndroidSchedulers.mainThread())
    }

    @Provides
    @Singleton
    fun provideAppExecutorsProvider(): ExecutorsProvider {
        return AppExecutorsProvider(Executors.newSingleThreadExecutor(), MainThreadExecutor())
    }
}