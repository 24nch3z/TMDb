package com.example.tmdb.di

import com.example.tmdb.data.datasource.MemoryMoviesDataSource
import com.example.tmdb.data.datasource.MoviesDataSource
import com.example.tmdb.data.datasource.NetworkMoviesDataSource
import com.example.tmdb.data.model.Movie
import com.example.tmdb.data.repository.MoviesRepository
import com.example.tmdb.data.repository.MoviesRepositoryImpl
import com.example.tmdb.domain.MoviesInteractor
import com.example.tmdb.domain.MoviesInteractorImpl
import com.example.tmdb.executor.SchedulersProvider
import com.example.tmdb.presentation.presentor.details.MovieDetailsPresenter
import com.example.tmdb.presentation.presentor.list.ListPresenter
import com.example.tmdb.presentation.presentor.list.MoviesPaginator
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class MoviesModule {

    companion object {
        private const val NETWORK_MOVIES_DATA_SOURCE = "NETWORK_MOVIES_DATA_SOURCE"
        private const val MEMORY_MOVIES_DATA_SOURCE = "MEMORY_MOVIES_DATA_SOURCE"
    }

    @Provides
    @Singleton
    @Named(NETWORK_MOVIES_DATA_SOURCE)
    fun provideNetworkDataSource(retrofit: Retrofit): MoviesDataSource {
        return NetworkMoviesDataSource(retrofit)
    }

    @Provides
    @Singleton
    @Named(MEMORY_MOVIES_DATA_SOURCE)
    fun provideMemoryDataSource(): MoviesDataSource {
        return MemoryMoviesDataSource()
    }

    @Provides
    @Singleton
    fun provideMoviesRepository(
            @Named(NETWORK_MOVIES_DATA_SOURCE) networkMoviesDataSource: MoviesDataSource,
            @Named(MEMORY_MOVIES_DATA_SOURCE) memoryMoviesDataSource: MoviesDataSource): MoviesRepository {
        return MoviesRepositoryImpl(networkMoviesDataSource, memoryMoviesDataSource)
    }

    @Provides
    @Singleton
    fun provideMoviesInteractor(
            provider: SchedulersProvider,
            moviesRepository: MoviesRepository): MoviesInteractor {
        return MoviesInteractorImpl(provider, moviesRepository)
    }

    @Provides
    @Singleton
    fun provideMoviesPaginator(
            schedulersProvider: SchedulersProvider,
            moviesInteractor: MoviesInteractor): MoviesPaginator<Movie> {
        return MoviesPaginator(schedulersProvider, moviesInteractor)
    }

    @Provides
    fun provideListPresenter(
            schedulersProvider: SchedulersProvider,
            moviesInteractor: MoviesInteractor,
            moviesPaginator: MoviesPaginator<Movie>): ListPresenter {
        return ListPresenter(schedulersProvider, moviesInteractor, moviesPaginator)
    }

    @Provides
    fun provideMovieDetailsPresenter(
            schedulersProvider: SchedulersProvider,
            moviesInteractor: MoviesInteractor): MovieDetailsPresenter {
        return MovieDetailsPresenter(schedulersProvider, moviesInteractor)
    }
}