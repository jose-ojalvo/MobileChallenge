package com.jojalvo.framework.base.usecase

import com.jojalvo.framework.base.network.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 *   @author jojalvo
 *   @since 3/5/23
 *   @email josealejandro025@gmail.com
 */
abstract class DataStateUseCase<in Params, ReturnType> where ReturnType : Any {

    protected abstract suspend fun FlowCollector<DataState<ReturnType>>.execute(params: Params)

    suspend operator fun invoke(params: Params) = flow {
        execute(params)
    }.flowOn(Dispatchers.IO)
}