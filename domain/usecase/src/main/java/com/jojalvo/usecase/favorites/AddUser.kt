package com.jojalvo.usecase.favorites

import androidx.annotation.VisibleForTesting
import com.jojalvo.entity.user.Result
import com.jojalvo.framework.base.usecase.LocalUseCase
import com.jojalvo.repository.favorites.FavoritesRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

/**
 *   @author jojalvo
 *   @since 3/5/23
 *   @email josealejandro025@gmail.com
 */
class AddUser
@Inject
constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val favRepository: FavoritesRepository
) : LocalUseCase<AddUser.Params, Unit>() {

    data class Params(
        val user: Result? = null
    )

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        favRepository.saveUserItem(params.user)
        emit(Unit)
    }
}