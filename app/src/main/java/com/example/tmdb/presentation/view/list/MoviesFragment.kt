package com.example.tmdb.presentation.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tmdb.App
import com.example.tmdb.R
import com.example.tmdb.data.model.Movie
import com.example.tmdb.presentation.presentor.list.ListPresenter
import kotlinx.android.synthetic.main.screen_list.*
import javax.inject.Inject

class MoviesFragment : Fragment(), MoviesView {

    @Inject
    lateinit var presenter: ListPresenter

    private lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as App).componentManager.dagger.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.screen_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MoviesAdapter()
        recycler_view.adapter = adapter

        presenter.bindView(this)
        presenter.loadMovies()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.removeView()
    }

    override fun setItems(items: List<Movie>) {
        adapter.setItems(items as ArrayList<Movie>)
    }

    override fun showProgress() {
        progress_view.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_view.visibility = View.GONE
    }
}