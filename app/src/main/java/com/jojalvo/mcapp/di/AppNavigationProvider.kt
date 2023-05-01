package com.jojalvo.mcapp.di

import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import com.jojalvo.provider.NavigationProvider
import com.jojalvo.settings.destinations.AboutScreenDestination
import com.jojalvo.settings.destinations.LanguageScreenDestination
import com.jojalvo.settings.destinations.TermsAndPrivacyScreenDestination
import com.jojalvo.settings.features.termsandprivacy.view.TermsAndPrivacyScreen
import com.jojalvo.users.detail.destinations.UserDetailScreenDestination

/**
 *   @author jojalvo
 *   @since 20/4/23
 *   @email josealejandro025@gmail.com
 */
class AppNavigationProvider constructor(
    private val navController: NavController
) : NavigationProvider {

    override fun navigateUp() {
        navController.navigateUp()
    }

    override fun openDetail() {
        navController.navigate(UserDetailScreenDestination)
    }

    override fun openTermAndPrivacy() {
        navController.navigate(TermsAndPrivacyScreenDestination)
    }

    override fun openAppLanguage() {
        navController.navigate(LanguageScreenDestination)
    }

    override fun openAbout() {
        navController.navigate(AboutScreenDestination)
    }
}