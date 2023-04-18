package com.jojalvo.onboarding

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.FragmentActivity
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.jojalvo.framework.base.jetpack.SetupSystemUi
import com.jojalvo.onboarding.navgraph.WelcomeNavGraph
import com.jojalvo.provider.LanguageProvider
import com.jojalvo.theme.MobileChallengeColors
import com.jojalvo.theme.MobileChallengeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 *   @author jojalvo
 *   @since 17/4/23
 *   @email josealejandro025@gmail.com
 */
@AndroidEntryPoint
class WelcomeActivity : FragmentActivity() {

    @Inject
    lateinit var languageProvider: LanguageProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            languageProvider.setLocale(languageProvider.getLanguageCode(), LocalContext.current)
            OnBoardingRoot()
        }
    }

    @Composable
    private fun OnBoardingRoot() {
        MobileChallengeTheme {
            SetupSystemUi(rememberSystemUiController(), MobileChallengeColors.primary)
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MobileChallengeColors.background
            ) {
                WelcomeNavGraph()
            }
        }
    }
}