package com.jojalvo.onboarding.navgraph

import com.jojalvo.onboarding.OnBoardingScreen

/**
 *   @author jojalvo
 *   @since 17/4/23
 *   @email josealejandro025@gmail.com
 */
sealed class WelcomeScreen(val route: String) {
    object OnBoarding : WelcomeScreen(route = "onBoarding_screen")
}