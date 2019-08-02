package com.example.tmdb.presentation.presentor.list

import com.example.tmdb.domain.MoviesInteractor
import com.example.tmdb.executor.SchedulersProvider
import com.example.tmdb.presentation.view.list.MoviesView
import ru.s4nchez.mvp.BasePresenter

class ListPresenter(
        private val schedulersProvider: SchedulersProvider,
        private val moviesInteractor: MoviesInteractor
) : BasePresenter<MoviesView>() {

    fun refresh() {
        view?.showProgress()
        moviesInteractor.getMovies(1)
                .observeOn(schedulersProvider.ui())
                .subscribe({
                    view?.setItems(it)
                }, {})
                .addToCompositeDisposable()
    }
}