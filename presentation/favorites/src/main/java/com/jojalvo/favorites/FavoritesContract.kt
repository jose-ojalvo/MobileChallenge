package com.jojalvo.favorites

import androidx.paging.PagingData
import com.jojalvo.entity.user.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

/**
 *   @author jojalvo
 *   @since 3/5/23
 *   @email josealejandro025@gmail.com
 */
data class FavoritesViewState(
    val pagedData: Flow<PagingData<Result>> = emptyFlow(),
    val userList: List<Result> = emptyList()
)