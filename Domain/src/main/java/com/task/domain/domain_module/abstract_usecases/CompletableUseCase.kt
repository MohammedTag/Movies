package com.task.domain.domain_module.abstract_usecases

import io.reactivex.Completable
import io.reactivex.Scheduler

abstract class CompletableUseCase<in Input> constructor(
    private val backgroundScheduler: Scheduler,
    private val foregroundScheduler: Scheduler
) {
    protected abstract fun createCompletable(input: Input? = null): Completable

    fun run(input: Input? = null): Completable {
        return createCompletable(input)
            .subscribeOn(backgroundScheduler)
            .observeOn(foregroundScheduler)
    }
}
