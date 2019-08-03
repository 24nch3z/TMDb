package com.example.tmdb.presentation.view.list

import androidx.paging.PagedList
import com.example.tmdb.data.model.Movie

interface MoviesView {
    fun setPagedList(list: PagedList<Movie>)
    fun showProgress()
    fun hideProgress()
}