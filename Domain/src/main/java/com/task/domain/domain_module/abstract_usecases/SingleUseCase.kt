package com.task.domain.domain_module.abstract_usecases

import io.reactivex.Scheduler
import io.reactivex.Single

abstract class SingleUseCase<Output, in Input> constructor(
    private val backgroundScheduler: Scheduler,
    private val foregroundScheduler: Scheduler
) {

    protected abstract fun createSingle(input: Input? = null): Single<Output>

    fun run(input: Input?): Single<Output> {
        return createSingle(input)
            .subscribeOn(backgroundScheduler)
            .observeOn(foregroundScheduler)
    }

}