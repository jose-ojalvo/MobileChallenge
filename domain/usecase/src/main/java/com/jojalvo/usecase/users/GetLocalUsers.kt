package com.jojalvo.usecase.users

import androidx.annotation.VisibleForTesting
import com.jojalvo.framework.base.network.DataState
import com.jojalvo.repository.users.UsersRepository
import javax.inject.Inject
import com.jojalvo.entity.user.Result
import com.jojalvo.framework.base.usecase.DataStateUseCase
import com.jojalvo.model.dto.users.toUserDtoList
import kotlinx.coroutines.flow.FlowCollector

/**
 *   @author jojalvo
 *   @since 3/5/23
 *   @email josealejandro025@gmail.com
 */
class GetLocalUsers
@Inject
constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val userRepository: UsersRepository
) : DataStateUseCase<Unit, List<Result>>() {

    override suspend fun FlowCollector<DataState<List<Result>>>.execute(params: Unit) {
        val results = userRepository.getLocalUserList()
        emit(DataState.Success(results.toUserDtoList()))
    }
}