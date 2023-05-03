package com.jojalvo.usecase.favorites

import androidx.annotation.VisibleForTesting
import com.jojalvo.framework.base.usecase.LocalUseCase
import com.jojalvo.repository.favorites.FavoritesRepository
import javax.inject.Inject
import com.jojalvo.entity.user.Result
import kotlinx.coroutines.flow.FlowCollector

/**
 *   @author jojalvo
 *   @since 3/5/23
 *   @email josealejandro025@gmail.com
 */
class DeleteUser
@Inject
constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val favRepository: FavoritesRepository
) : LocalUseCase<DeleteUser.Params, Unit>() {

    data class Params(
        val user: Result? = null
    )

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        params.user?.name?.let { name ->
            favRepository.deleteUser(
                title = name.title,
                first = name.first,
                last = name.last
            )
        }
        emit(Unit)
    }
}