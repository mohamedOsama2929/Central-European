package com.team.domain.utils

import com.team.domain.excuter.PostExecutionThread
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn


/**
 * Abstract class for a UseCase that returns an instance of a [Single].
 */
abstract class FlowUseCase<T, in Params> constructor(
    private val postExecutionThread: PostExecutionThread
) {


    /**
     * Builds a [Single] which will be used when the current [FlowUseCase] is executed.
     */
    protected abstract suspend fun buildUseCaseObservable(params: Params? = null): Flow<T>

    /**
     * Executes the current use case.
     */
    open suspend fun execute(params: Params? = null): Flow<T> {
        return this.buildUseCaseObservable(params)
            .flowOn(Dispatchers.IO)
//        addDisposable(single.subscribeWith(singleObserver))
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    /*  fun dispose() {
          if (!disposables.isDisposed) disposables.dispose()
      }*/

    /**
     * Dispose from current [CompositeDisposable].
     */
    /* private fun addDisposable(disposable: Disposable) {
         disposables.add(disposable)
     }*/

}