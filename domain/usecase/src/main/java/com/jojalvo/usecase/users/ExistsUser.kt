package com.jojalvo.usecase.users

import androidx.annotation.VisibleForTesting
import com.jojalvo.framework.base.network.DataState
import com.jojalvo.framework.base.usecase.DataStateUseCase
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
    internal val userRepository: UsersRepository
) : DataStateUseCase<ExistsUser.Params, Boolean>() {

    data class Params(
        val title: String,
        val first: String,
        val last: String
    )

    override suspend fun FlowCollector<DataState<Boolean>>.execute(params: Params) {
        val results = userRepository.existsUser(params.title, params.first, params.last)
        emit(DataState.Success(results))
    }

}