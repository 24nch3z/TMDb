package com.example.tmdb.data.datasource

import com.example.tmdb.data.model.Discover
import io.reactivex.Single

interface DataSource {
    fun getMovies(): Single<Discover>
}