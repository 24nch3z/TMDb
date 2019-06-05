package com.example.tmdb.data.repository

import com.example.tmdb.data.model.Movie
import io.reactivex.Single

interface MoviesRepository {
    fun getMovies(): Single<List<Movie>>
}