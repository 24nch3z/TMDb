package com.example.tmdb.data

import com.example.tmdb.data.model.Discover
import com.example.tmdb.data.model.MovieDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://api.themoviedb.org/3/"

// https://api.themoviedb.org/3/discover/movie?api_key=1d7ec7f351cabadacfd8e9fcd338385d&language=ru-RU&sort_by=popularity.desc&page=1

interface ApiInterface {

    @GET("discover/movie")
    fun getMovies(
            @Query("api_key") apiKey: String,
            @Query("language") language: String,
            @Query("sort_by") sortBy: String,
            @Query("page") page: Int
    ): Call<Discover>

    @GET("movie/{movie_id}")
    fun getMovie(
            @Path("movie_id") movieId: Int,
            @Query("api_key") apiKey: String
    ): Call<MovieDetails>
}