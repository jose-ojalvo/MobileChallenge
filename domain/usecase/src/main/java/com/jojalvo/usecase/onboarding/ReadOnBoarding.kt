package com.jojalvo.usecase.onboarding

import androidx.annotation.VisibleForTesting
import com.jojalvo.framework.base.usecase.ReturnUseCase
import com.jojalvo.repository.onboarding.OnBoardingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 *   @author jojalvo
 *   @since 13/4/23
 *   @email josealejandro025@gmail.com
 */
class ReadOnBoarding @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: OnBoardingRepository
) : ReturnUseCase<Unit, Boolean>() {

    override suspend fun execute(params: Unit): Flow<Boolean> = repository.readOnBoardingState()

}