package com.jojalvo.users.list.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.jojalvo.framework.base.mvvm.MvvmViewModel
import com.jojalvo.usecase.users.GetCachedUsers
import com.jojalvo.usecase.users.GetRemoteUsers
import com.jojalvo.users.UsersViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 *   @author jojalvo
 *   @since 24/4/23
 *   @email josealejandro025@gmail.com
 */
@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getCachedUsers: GetCachedUsers,
    private val getRemoteUsers: GetRemoteUsers
) : MvvmViewModel() {

    private val _uiState = MutableStateFlow<UsersUIState<*>>(UsersUIState.Empty)
    val uiState = _uiState.asStateFlow()

    private val config = PagingConfig(pageSize = 0)

    override fun handleError(exception: Throwable) {
        _uiState.value = UsersUIState.Error(exception)
    }

    fun getCachedUsers() = safeLaunch {
        _uiState.value = UsersUIState.Loading
        val params = GetCachedUsers.Params(config)
        val pagedFlow = getCachedUsers(params).cachedIn(scope = viewModelScope)
        _uiState.value = UsersUIState.UsersData(UsersViewState(pagedData = pagedFlow))
    }

    fun getRemoteUsers() = safeLaunch {
        _uiState.value = UsersUIState.Loading
        val params = GetRemoteUsers.Params(config)
        val pagedFlow = getRemoteUsers(params).cachedIn(scope = viewModelScope)
        _uiState.value = UsersUIState.UsersData(UsersViewState(pagedData = pagedFlow))
    }
}