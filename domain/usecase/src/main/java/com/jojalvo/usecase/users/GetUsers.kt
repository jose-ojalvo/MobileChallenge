package com.jojalvo.usecase.users

import androidx.annotation.VisibleForTesting
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jojalvo.framework.base.usecase.FlowPagingUseCase
import com.jojalvo.entity.user.Result
import com.jojalvo.repository.users.UsersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 *   @author jojalvo
 *   @since 30/4/23
 *   @email josealejandro025@gmail.com
 */
class GetUsers @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: UsersRepository
) : FlowPagingUseCase<GetUsers.Params, Result>() {

    data class Params(
        val pagingConfig: PagingConfig
    )

    override fun execute(params: Params): Flow<PagingData<Result>> {
        return Pager(
            config = params.pagingConfig,
            pagingSourceFactory = { UserPagingSource(repository) },
        ).flow
    }


}