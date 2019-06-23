package com.example.tmdb.data.datasource

import com.example.tmdb.BuildConfig
import com.example.tmdb.data.ApiInterface
import com.example.tmdb.data.common.BaseNetworkDataSource
import com.example.tmdb.data.model.Discover
import io.reactivex.Single
import retrofit2.Response

class NetworkDataSource(private val api: ApiInterface) : BaseNetworkDataSource(), DataSource {

    override fun getMovies(): Single<Discover> {
        return makeRequest(api.getMovies(BuildConfig.ApiKey, "ru-RU", "popularity.desc", 2))
    }

    override fun <T> handleError(response: Response<T>): Exception {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}