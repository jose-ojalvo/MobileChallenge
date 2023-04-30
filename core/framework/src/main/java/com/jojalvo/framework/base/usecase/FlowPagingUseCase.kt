package com.jojalvo.framework.base.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

/**
 *   @author jojalvo
 *   @since 30/4/23
 *   @email josealejandro025@gmail.com
 */
abstract class FlowPagingUseCase<in Params, ReturnType> where ReturnType : Any {

    protected abstract fun execute(params: Params): Flow<PagingData<ReturnType>>

    operator fun invoke(params: Params): Flow<PagingData<ReturnType>> = execute(params)
        .flowOn(Dispatchers.IO)

}