package com.example.tmdb.presentation.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdb.App
import com.example.tmdb.R
import com.example.tmdb.data.model.Movie
import com.example.tmdb.presentation.presentor.list.ListPresenter
import com.example.tmdb.presentation.view.details.MovieDetailsFragment
import kotlinx.android.synthetic.main.screen_movies_list.*
import javax.inject.Inject

class MoviesFragment : Fragment(), MoviesView, MoviesAdapter.ClickListener {

    @Inject
    lateinit var presenter: ListPresenter

    private lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as App).componentManager.dagger.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.screen_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MoviesAdapter(this)
        recycler_view.adapter = adapter
        val layoutManager = recycler_view.layoutManager as LinearLayoutManager
        recycler_view.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val totalItemCount = layoutManager.itemCount
                val visibleItemCount = layoutManager.childCount
                val lastVisibleItem = layoutManager.findLastVisibleItemPosition()
                val visibleThreshold = 5

//                if (visibleItemCount + lastVisibleItem + visibleThreshold >= totalItemCount) {
//                    presenter.loadMore()
//                }
            }
        })

        presenter.bindView(this)
        presenter.init()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.removeView()
    }

    override fun setPagedList(list: PagedList<Movie>) {
        adapter.submitList(list)
    }

    override fun showProgress() {
        progress_view.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_view.visibility = View.GONE
    }

    override fun onClick(movie: Movie) {
        fragmentManager?.beginTransaction()
                ?.add(R.id.container, MovieDetailsFragment.getInstance(movie.id))
                ?.addToBackStack(null)
                ?.commitAllowingStateLoss()
    }
}