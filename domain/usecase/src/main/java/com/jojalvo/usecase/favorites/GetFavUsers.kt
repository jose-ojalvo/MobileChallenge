package com.jojalvo.usecase.favorites

import androidx.annotation.VisibleForTesting
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jojalvo.entity.user.Result
import com.jojalvo.framework.base.usecase.FlowPagingUseCase
import com.jojalvo.repository.favorites.FavoritesRepository
import com.jojalvo.usecase.users.FavUserPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 *   @author jojalvo
 *   @since 3/5/23
 *   @email josealejandro025@gmail.com
 */
class GetFavUsers
@Inject
constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val favRepository: FavoritesRepository
) : FlowPagingUseCase<GetFavUsers.Params, Result>() {

    data class Params(
        val pagingConfig: PagingConfig
    )

    override fun execute(params: Params): Flow<PagingData<Result>> {
        return Pager(
            config = params.pagingConfig,
            pagingSourceFactory = { FavUserPagingSource(favRepository) }
        ).flow
    }
}