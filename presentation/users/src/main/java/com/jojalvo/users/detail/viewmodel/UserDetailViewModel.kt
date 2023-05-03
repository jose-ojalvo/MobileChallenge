package com.jojalvo.users.detail.viewmodel

import com.jojalvo.entity.user.Result
import com.jojalvo.framework.base.mvvm.MvvmViewModel
import com.jojalvo.usecase.favorites.AddUser
import com.jojalvo.usecase.favorites.DeleteUser
import com.jojalvo.usecase.favorites.ExistsUser
import com.jojalvo.utils.extension.safeNull
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 *   @author jojalvo
 *   @since 1/5/23
 *   @email josealejandro025@gmail.com
 */
@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val existsUser: ExistsUser,
    private val addUser: AddUser,
    private val deleteUser: DeleteUser
) : MvvmViewModel() {

    private val _uiState = MutableStateFlow<UserDetailUIState<*>>(UserDetailUIState.Empty)
    val uiState = _uiState.asStateFlow()

    fun addToFavorites(data: Result) = safeLaunch {
        val params = AddUser.Params(user = data)
        call(addUser(params)) {
            searchExistingUsers(data)
        }
    }

    fun removeFromFavorites(data: Result) = safeLaunch {
        val params = DeleteUser.Params(user = data)
        call(deleteUser(params)) {
            searchExistingUsers(data)
        }
    }

    fun searchExistingUsers(data: Result) = safeLaunch {
        val params = ExistsUser.Params(
            title = data.name?.title.safeNull(),
            first = data.name?.first.safeNull(),
            last = data.name?.last.safeNull(),
        )
        call(existsUser(params)) { exists ->
            if (exists) {
                _uiState.value = UserDetailUIState.ExistingUser
            } else {
                _uiState.value = UserDetailUIState.Empty
            }
        }
    }
}