package com.jojalvo.mcapp.di

import androidx.navigation.NavController
import com.jojalvo.provider.NavigationProvider

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
        // Nothing to do yet
    }

    override fun openTermAndPrivacy() {
        // Nothing to do yet
    }

    override fun openAppLanguage() {
        // Nothing to do yet
    }

    override fun openAbout() {
        // Nothing to do yet
    }
}