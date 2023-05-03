package com.jojalvo.favorites.viewmodel

/**
 *   @author jojalvo
 *   @since 3/5/23
 *   @email josealejandro025@gmail.com
 */
interface FavoritesUIState<out T> {
    object Loading : FavoritesUIState<Nothing>
    data class Error(val throwable: Throwable) : FavoritesUIState<Nothing>
    data class UsersData<T>(val result: T) : FavoritesUIState<T>
    object Empty : FavoritesUIState<Nothing>
}