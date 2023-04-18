package com.jojalvo.splash

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.jojalvo.utils.extension.launchActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

/**
 *   @author jojalvo
 *   @since 1/4/23
 *   @email josealejandro025@gmail.com
 */
@AndroidEntryPoint
class StartActivity : ComponentActivity() {

    private val viewModel by viewModels<StartViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        launchSplash()
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.startOnBoarding.collectLatest {
                    delay(2.seconds)
                    if (it) navigateOnBoardingActivity() else navigateMainActivity()
                }
            }
        }
    }

    private fun launchSplash() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val splashScreen = installSplashScreen()
            splashScreen.setKeepOnScreenCondition { true }
        }
    }

    private fun navigateOnBoardingActivity() {
        launchActivity(
            packageName = packageName,
            className = "com.jojalvo.onboarding.WelcomeActivity"
        ).also {
            finish()
        }
    }

    private fun navigateMainActivity() {
        launchActivity(
            packageName = packageName,
            className = "com.jojalvo.mcapp.navigation.MainActivity"
        ).also {
            finish()
        }
    }

}