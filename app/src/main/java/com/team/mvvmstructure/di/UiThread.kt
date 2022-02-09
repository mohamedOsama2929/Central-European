package com.team.mvvmstructure.di


import com.team.domain.excuter.PostExecutionThread
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * MainThread (UI Thread) implementation based on a [Scheduler]
 * which will execute actions on the Android UI thread
 */
class UiThread @Inject internal constructor() : PostExecutionThread {

    override val scheduler: CoroutineScope
        get() = CoroutineScope(Dispatchers.Main)

}