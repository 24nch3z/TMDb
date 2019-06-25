package com.example.tmdb.presentation.presentor.details

import com.example.tmdb.domain.MoviesInteractor
import com.example.tmdb.executor.SchedulersProvider
import com.example.tmdb.presentation.view.details.MovieDetailsView
import ru.s4nchez.logger.Logger
import ru.s4nchez.mvp.BasePresenter

class MovieDetailsPresenter(
        private val schedulersProvider: SchedulersProvider,
        private val moviesInteractor: MoviesInteractor
) : BasePresenter<MovieDetailsView>() {

    fun loadMovie(movieId: Int) {
        val d = moviesInteractor.getMovie(movieId)
                .observeOn(schedulersProvider.ui())
                .subscribe({
                    Logger.d()
                }, {})
        disposable.add(d)
    }
}