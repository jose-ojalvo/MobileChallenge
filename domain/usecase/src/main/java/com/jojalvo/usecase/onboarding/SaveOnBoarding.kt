package com.jojalvo.usecase.onboarding

import androidx.annotation.VisibleForTesting
import com.jojalvo.framework.base.usecase.LocalUseCase
import com.jojalvo.repository.onboarding.OnBoardingRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

/**
 *   @author jojalvo
 *   @since 13/4/23
 *   @email josealejandro025@gmail.com
 */
class SaveOnBoarding @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: OnBoardingRepository
): LocalUseCase<SaveOnBoarding.Params, Unit>() {

    data class Params(
        val completed: Boolean
    )

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        repository.writeOnBoardingState(params.completed)
        emit(Unit)
    }


}