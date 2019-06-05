package com.example.tmdb.di

import com.example.tmdb.presentation.view.list.MoviesFragment
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        SchedulerModule::class,
        MoviesModule::class
    ]
)
@Singleton
interface AppComponent {
    fun inject(view: MoviesFragment)
}