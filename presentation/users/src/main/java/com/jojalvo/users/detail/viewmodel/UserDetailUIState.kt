package com.jojalvo.users.detail.viewmodel

import com.jojalvo.entity.user.Result


/**
 *   @author jojalvo
 *   @since 1/5/23
 *   @email josealejandro025@gmail.com
 */
interface UserDetailUIState<out T> {
    object Loading : UserDetailUIState<Nothing>
    object ExistingUser: UserDetailUIState<Nothing>
    object Empty : UserDetailUIState<Nothing>
}