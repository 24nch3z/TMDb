package com.example.tmdb.presentation.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tmdb.App
import com.example.tmdb.R
import com.example.tmdb.presentation.presentor.details.MovieDetailsPresenter
import javax.inject.Inject

/*
    Постер фильма
    Постер фильма как подложка на кинопоиске (ч\б)
    Название
    Дата релиза (или год)
    Пометка для взрослых
    Страница фильма
    Страница на IMDB
    Описание
    Список производителей
    Страны
    Выручка
    Статус фильма
    Слоган
    Оценка
    Жанры
 */
class MovieDetailsFragment : Fragment(), MovieDetailsView {

    @Inject
    lateinit var presenter: MovieDetailsPresenter

    private var movieId: Int = 0

    companion object {
        private const val ARG_MOVIE_ID = "movieId"

        fun getInstance(movieId: Int): MovieDetailsFragment {
            return MovieDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_MOVIE_ID, movieId)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as App).componentManager.dagger.inject(this)
        movieId = arguments?.getInt(ARG_MOVIE_ID) ?: 0
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.screen_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.bindView(this)
        presenter.loadMovie(movieId)
    }
}