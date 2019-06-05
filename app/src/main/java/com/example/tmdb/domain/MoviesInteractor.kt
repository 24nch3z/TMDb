package com.example.tmdb.domain

import com.example.tmdb.data.model.Movie
import io.reactivex.Single

interface MoviesInteractor {
    fun getMovies(): Single<List<Movie>>
}