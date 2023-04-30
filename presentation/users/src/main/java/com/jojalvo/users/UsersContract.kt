package com.jojalvo.users

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import com.jojalvo.entity.user.Result

/**
 *   @author jojalvo
 *   @since 30/4/23
 *   @email josealejandro025@gmail.com
 */
data class UsersViewState(
    val pagedData: Flow<PagingData<Result>> = emptyFlow()
)