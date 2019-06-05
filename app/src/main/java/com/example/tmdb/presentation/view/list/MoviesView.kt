package com.example.tmdb.presentation.view.list

import com.example.tmdb.data.model.Movie

interface MoviesView {
    fun setItems(items: List<Movie>)
}