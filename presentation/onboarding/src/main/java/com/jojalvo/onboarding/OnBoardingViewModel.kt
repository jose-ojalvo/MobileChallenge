package com.jojalvo.onboarding

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.jojalvo.framework.base.mvvm.MvvmViewModel
import com.jojalvo.usecase.onboarding.SaveOnBoarding
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 *   @author jojalvo
 *   @since 17/4/23
 *   @email josealejandro025@gmail.com
 */
@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val saveOnBoarding: SaveOnBoarding
) : MvvmViewModel() {

    fun saveOnBoardingState(completed: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        val params = SaveOnBoarding.Params(completed)
        call(saveOnBoarding(params))
    }

}