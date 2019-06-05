package com.example.tmdb.di

import com.example.tmdb.data.ApiInterface
import com.example.tmdb.data.datasource.DataSource
import com.example.tmdb.data.datasource.NetworkDataSource
import com.example.tmdb.data.repository.MoviesRepository
import com.example.tmdb.data.repository.MoviesRepositoryImpl
import com.example.tmdb.domain.MoviesInteractor
import com.example.tmdb.domain.MoviesInteractorImpl
import com.example.tmdb.executor.SchedulersProvider
import com.example.tmdb.presentation.presentor.list.ListPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MoviesModule {

    @Provides
    @Singleton
    fun provideDataSource(api: ApiInterface): DataSource {
        return NetworkDataSource(api)
    }

    @Provides
    @Singleton
    fun provideMoviesRepository(networkDataSource: DataSource): MoviesRepository {
        return MoviesRepositoryImpl(networkDataSource)
    }

    @Provides
    @Singleton
    fun provideMoviesInteractor(provider: SchedulersProvider, moviesRepository: MoviesRepository): MoviesInteractor {
        return MoviesInteractorImpl(provider, moviesRepository)
    }

    @Provides
    @Singleton
    fun provideListPresenter(
        schedulersProvider: SchedulersProvider,
        moviesInteractor: MoviesInteractor
    ): ListPresenter {
        return ListPresenter(schedulersProvider, moviesInteractor)
    }
}