package com.jojalvo.users.list.viewmodel

/**
 *   @author jojalvo
 *   @since 24/4/23
 *   @email josealejandro025@gmail.com
 */
interface UsersUIState<out T> {
    object Loading : UsersUIState<Nothing>
    data class Error(val throwable: Throwable) : UsersUIState<Nothing>
    data class UsersData<T>(val result: T) : UsersUIState<T>
    data class UsersList<T>(val result: List<T>) : UsersUIState<T>
    object Empty : UsersUIState<Nothing>
}