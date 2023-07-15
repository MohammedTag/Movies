package com.task.domain.domain_module.abstract_usecases

import io.reactivex.Observable
import io.reactivex.Scheduler

abstract class ObservableUseCase<Output, in Input> constructor(
    private val backgroundScheduler: Scheduler,
    private val foregroundScheduler: Scheduler
) {

    protected abstract fun createObservable(input: Input? = null): Observable<Output>

    fun run(input: Input?): Observable<Output> {
        return createObservable(input)
            .subscribeOn(backgroundScheduler)
            .observeOn(foregroundScheduler)
    }

}