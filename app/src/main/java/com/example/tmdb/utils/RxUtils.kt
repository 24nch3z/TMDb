package com.example.tmdb.utils

import com.example.tmdb.executor.SchedulersProvider
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single

fun <T> Single<T>.applySchedulers(schedulersProvider: SchedulersProvider): Single<T> {
    return this.applySchedulers(
            subscribeOn = schedulersProvider.io(),
            observeOn = schedulersProvider.ui())
}

fun <T> Observable<T>.applySchedulers(schedulersProvider: SchedulersProvider): Observable<T> {
    return this.applySchedulers(
            subscribeOn = schedulersProvider.io(),
            observeOn = schedulersProvider.ui())
}

fun Completable.applySchedulers(schedulersProvider: SchedulersProvider): Completable {
    return this.applySchedulers(
            subscribeOn = schedulersProvider.io(),
            observeOn = schedulersProvider.ui())
}

fun <T> Single<T>.applySchedulers(subscribeOn: Scheduler, observeOn: Scheduler): Single<T> {
    return this
            .subscribeOn(subscribeOn)
            .observeOn(observeOn)
}

fun <T> Observable<T>.applySchedulers(subscribeOn: Scheduler, observeOn: Scheduler): Observable<T> {
    return this
            .subscribeOn(subscribeOn)
            .observeOn(observeOn)
}

fun Completable.applySchedulers(subscribeOn: Scheduler, observeOn: Scheduler): Completable {
    return this
            .subscribeOn(subscribeOn)
            .observeOn(observeOn)
}