package com.jojalvo.users.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.jojalvo.framework.base.mvvm.MvvmViewModel
import com.jojalvo.usecase.users.GetUsers
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
    private val getUsers: GetUsers
) : MvvmViewModel() {

    private val _uiState = MutableStateFlow<UsersUIState<*>>(UsersUIState.Empty)
    val uiState = _uiState.asStateFlow()

    private val config = PagingConfig(pageSize = 0)

    override fun handleError(exception: Throwable) {
        _uiState.value = UsersUIState.Error(exception)
    }

    fun getUsers() = safeLaunch {
        _uiState.value = UsersUIState.Loading
        val params = GetUsers.Params(config)
        val pagedFlow = getUsers(params).cachedIn(scope = viewModelScope)
        _uiState.value = UsersUIState.UsersData(UsersViewState(pagedData = pagedFlow))
    }
}