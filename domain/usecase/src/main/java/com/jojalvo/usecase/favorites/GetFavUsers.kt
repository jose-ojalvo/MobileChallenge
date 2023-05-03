package com.jojalvo.usecase.favorites

import androidx.annotation.VisibleForTesting
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jojalvo.entity.user.Result
import com.jojalvo.framework.base.usecase.LocalUseCase
import com.jojalvo.repository.favorites.FavoritesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
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
) : LocalUseCase<Unit, List<Result>>() {

    override suspend fun FlowCollector<List<Result>>.execute(params: Unit) {
        val list = favRepository.getFavUsers()
        emit(list)
    }
}