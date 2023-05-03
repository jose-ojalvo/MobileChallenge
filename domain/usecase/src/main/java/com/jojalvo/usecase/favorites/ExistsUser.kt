package com.jojalvo.usecase.favorites

import androidx.annotation.VisibleForTesting
import com.jojalvo.framework.base.network.DataState
import com.jojalvo.framework.base.usecase.DataStateUseCase
import com.jojalvo.framework.base.usecase.LocalUseCase
import com.jojalvo.repository.favorites.FavoritesRepository
import com.jojalvo.repository.users.UsersRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

/**
 *   @author jojalvo
 *   @since 3/5/23
 *   @email josealejandro025@gmail.com
 */
class ExistsUser
@Inject
constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val userRepository: FavoritesRepository
) : LocalUseCase<ExistsUser.Params, Boolean>() {

    data class Params(
        val title: String,
        val first: String,
        val last: String
    )

    override suspend fun FlowCollector<Boolean>.execute(params: Params) {
        val result = userRepository.existsUser(params.title, params.first, params.last)
        emit(result)
    }
}