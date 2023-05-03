package com.jojalvo.favorites.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.map
import com.jojalvo.favorites.FavoritesViewState
import com.jojalvo.framework.base.mvvm.MvvmViewModel
import com.jojalvo.usecase.favorites.GetFavUsers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEmpty
import javax.inject.Inject

/**
 *   @author jojalvo
 *   @since 3/5/23
 *   @email josealejandro025@gmail.com
 */
@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavUsers: GetFavUsers
) : MvvmViewModel() {

    private val _uiState = MutableStateFlow<FavoritesUIState<*>>(FavoritesUIState.Empty)
    val uiState = _uiState.asStateFlow()

    fun getFavUsers() = safeLaunch {
        _uiState.value = FavoritesUIState.Loading
        call(getFavUsers(Unit)) {
            if (it.isNotEmpty()) {
                _uiState.value = FavoritesUIState.UsersData(FavoritesViewState(userList = it))
            } else {
                _uiState.value = FavoritesUIState.Empty
            }
        }
    }
}