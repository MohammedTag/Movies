package com.task.airalo.presentation_module

import androidx.lifecycle.ViewModel
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import org.reactivestreams.Subscription

abstract class BaseViewModel : ViewModel() {

    private val disposables = CompositeDisposable()


    protected fun <T> executeObservable(
        loadingConsumer: Consumer<Disposable>,
        successConsumer: Consumer<T>,
        throwableConsumer: Consumer<Throwable>,
        useCase: Observable<T>
    ) {
        val observable = useCase
            .doOnSubscribe(loadingConsumer)

        addDisposable(observable.subscribe(successConsumer, throwableConsumer))
    }

    protected fun <T> executeFlowable(
        loadingConsumer: Consumer<Subscription>,
        successConsumer: Consumer<T>,
        throwableConsumer: Consumer<Throwable>,
        useCase: Flowable<T>
    ) {
        val observable = useCase
            .doOnSubscribe(loadingConsumer)

        addDisposable(observable.subscribe(successConsumer, throwableConsumer))
    }

    protected fun executeCompletable(
        loadingConsumer: Consumer<Disposable>,
        successConsumer: Action,
        throwableConsumer: Consumer<Throwable>,
        useCase: Completable
    ) {
        val observable: Completable = useCase
            .doOnSubscribe(loadingConsumer)

        addDisposable(observable.subscribe(successConsumer, throwableConsumer))
    }

    protected fun <T> executeSingle(
        loadingConsumer: Consumer<Disposable>,
        successConsumer: Consumer<T>,
        throwableConsumer: Consumer<Throwable>,
        useCase: Single<T>
    ) {
        val observable = useCase
            .doOnSubscribe(loadingConsumer)

        addDisposable(observable.subscribe(successConsumer, throwableConsumer))
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    private fun dispose() {
        if (!disposables.isDisposed)
            disposables.dispose()
    }

    override fun onCleared() {
        super.onCleared()
        dispose()
    }
}
