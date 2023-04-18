package com.jojalvo.onboarding.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jojalvo.onboarding.OnBoardingScreen

/**
 *   @author jojalvo
 *   @since 17/4/23
 *   @email josealejandro025@gmail.com
 */
@Composable
fun WelcomeNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = WelcomeScreen.OnBoarding.route
    ) {
        composable(route = WelcomeScreen.OnBoarding.route) {
            OnBoardingScreen()
        }
    }
}