package com.jojalvo.framework.base.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

/**
 *   @author jojalvo
 *   @since 13/4/23
 *   @email josealejandro025@gmail.com
 */
abstract class ReturnUseCase<in Params, ReturnType> where ReturnType : Any {

    protected abstract suspend fun execute(params: Params): Flow<ReturnType>

    suspend operator fun invoke(params: Params): Flow<ReturnType> =
        execute(params).flowOn(Dispatchers.IO)

}