package com.example.tmdb.presentation.presentor.list

import com.example.tmdb.data.model.Movie
import com.example.tmdb.domain.MoviesInteractor
import com.example.tmdb.executor.SchedulersProvider
import com.example.tmdb.presentation.view.list.MoviesView
import ru.s4nchez.mvp.BasePresenter

class ListPresenter(
        private val schedulersProvider: SchedulersProvider,
        private val moviesInteractor: MoviesInteractor
) : BasePresenter<MoviesView>(), Paginator.ViewController<Movie> {

    init {

    }

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

    override fun showEmptyProgress(show: Boolean) {

    }

    override fun showEmptyError(show: Boolean, error: Throwable?) {

    }

    override fun showEmptyView(show: Boolean) {

    }

    override fun showData(show: Boolean, data: List<Movie>) {

    }

    override fun showErrorMessage(error: Throwable) {

    }

    override fun showRefreshProgress(show: Boolean) {

    }

    override fun showPageProgress(show: Boolean) {

    }
}