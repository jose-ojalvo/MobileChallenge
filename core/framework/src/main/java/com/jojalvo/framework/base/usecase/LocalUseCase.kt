package com.jojalvo.framework.base.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 *   @author jojalvo
 *   @since 14/4/23
 *   @email josealejandro025@gmail.com
 */
abstract class LocalUseCase<in Params, ReturnType> where ReturnType : Any {

    protected abstract suspend fun FlowCollector<ReturnType>.execute(params: Params)

    suspend operator fun invoke(params: Params) = flow { execute(params) }.flowOn(Dispatchers.IO)
}