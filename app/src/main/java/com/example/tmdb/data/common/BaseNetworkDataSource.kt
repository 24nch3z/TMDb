package com.example.tmdb.data.common

import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import ru.s4nchez.logger.Logger
import java.io.IOException

abstract class BaseNetworkDataSource {

    fun <T> makeRequest(call: Call<T>): Single<T> {
        return Single.create { emitter ->
            try {
                val response = call.execute()
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    responseBody?.let { emitter.onSuccess(it) }
                } else {
                    Logger.d("Error with url: ", call.request().url())
                    Logger.d("Response code:  ", response.code())
                    Logger.d("Response error: ", response.errorBody()?.string())
                    emitter.onError(handleError(response))
                }
            } catch (e: IOException) {
                Logger.d("Error with url: ", call.request().url())
                if (!emitter.isDisposed)
                    emitter.onError(e)
            }
        }
    }


    abstract fun <T> handleError(response: Response<T>): Exception
}