package com.jojalvo.users.viewmodel

import com.jojalvo.framework.base.mvvm.MvvmViewModel
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
class UsersViewModel @Inject constructor() : MvvmViewModel() {

    private val _uiState = MutableStateFlow<UsersUIState<*>>(UsersUIState.Empty)
    val uiState = _uiState.asStateFlow()

    override fun handleError(exception: Throwable) {
        _uiState.value = UsersUIState.Error(exception)
    }

    fun getUsers() = safeLaunch {
        _uiState.value = UsersUIState.Loading
    }
}