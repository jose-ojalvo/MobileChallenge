package com.jojalvo.splash

import com.jojalvo.framework.base.mvvm.MvvmViewModel
import com.jojalvo.usecase.onboarding.ReadOnBoarding
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 *   @author jojalvo
 *   @since 1/4/23
 *   @email josealejandro025@gmail.com
 */
@HiltViewModel
class StartViewModel @Inject constructor(
    private val readOnBoarding: ReadOnBoarding
): MvvmViewModel() {

    private val _startOnBoarding = MutableStateFlow(false)
    val startOnBoarding = _startOnBoarding.asStateFlow()

    init {
        readOnBoardingState()
    }

    private fun readOnBoardingState() = safeLaunch {
        call(readOnBoarding(Unit)) { completed ->
            _startOnBoarding.value = !completed
        }
    }
}