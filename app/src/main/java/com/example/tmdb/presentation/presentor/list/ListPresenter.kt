package com.example.tmdb.presentation.presentor.list

import com.example.tmdb.domain.MoviesInteractor
import com.example.tmdb.executor.SchedulersProvider
import com.example.tmdb.presentation.view.list.MoviesView
import ru.s4nchez.mvp.BasePresenter

class ListPresenter(
        private val schedulersProvider: SchedulersProvider,
        private val moviesInteractor: MoviesInteractor
) : BasePresenter<MoviesView>() {

    fun loadMovies() {
        view?.showProgress()
        val d = moviesInteractor.getMovies()
                .observeOn(schedulersProvider.ui())
                .subscribe({
                    view?.setItems(it)
                    view?.hideProgress()
                }, {
                    view?.hideProgress()
                })
        disposable.add(d)
    }
}