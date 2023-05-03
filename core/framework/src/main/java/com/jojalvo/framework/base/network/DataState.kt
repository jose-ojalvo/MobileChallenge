package com.jojalvo.framework.base.network

/**
 *   @author jojalvo
 *   @since 2/5/23
 *   @email josealejandro025@gmail.com
 */
sealed class DataState<out T> {
    data class Success<out T>(val result: T) : DataState<T>()
    data class Error(val error: Throwable) : DataState<Nothing>()
}
