package com.jojalvo.framework.base.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jojalvo.framework.base.network.DataState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 *   @author jojalvo
 *   @since 6/4/23
 *   @email josealejandro025@gmail.com
 */
abstract class MvvmViewModel : ViewModel() {

    companion object {
        private const val SAFE_LAUNCH_EXCEPTION = "ViewModel-ExceptionHandler"
    }

    private val handler = CoroutineExceptionHandler { _, throwable ->
        Timber.tag(SAFE_LAUNCH_EXCEPTION).e(throwable)
        handleError(throwable)
    }

    open fun handleError(exception: Throwable) {}

    open fun startLoading() {}

    protected fun safeLaunch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(handler, block = block)
    }

    protected suspend fun <T> call(
        callFlow: Flow<T>,
        completionHandler: (collect: T) -> Unit = {}
    ) {
        callFlow
            .catch { handleError(it) }
            .collect {
                completionHandler.invoke(it)
            }
    }

    protected suspend fun <T> execute(
        callFlow: Flow<DataState<T>>,
        completionHandler: (collect: T) -> Unit = {}
    ) {
        callFlow
            .onStart { startLoading() }
            .catch { handleError(it) }
            .collect { state ->
                when (state) {
                    is DataState.Error -> handleError(state.error)
                    is DataState.Success -> completionHandler.invoke(state.result)
                }
            }
    }
}