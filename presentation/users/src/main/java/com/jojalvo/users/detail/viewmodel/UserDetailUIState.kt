package com.jojalvo.users.detail.viewmodel


/**
 *   @author jojalvo
 *   @since 1/5/23
 *   @email josealejandro025@gmail.com
 */
interface UserDetailUIState<out T> {
    object Loading : UserDetailUIState<Nothing>
    data class Error(val throwable: Throwable) : UserDetailUIState<Nothing>
    data class UserDetail<T>(val result: T) : UserDetailUIState<T>
    object Empty : UserDetailUIState<Nothing>
}