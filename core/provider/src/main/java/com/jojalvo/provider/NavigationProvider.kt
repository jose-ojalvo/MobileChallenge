package com.jojalvo.provider

import com.jojalvo.entity.user.Result

/**
 *   @author jojalvo
 *   @since 20/4/23
 *   @email josealejandro025@gmail.com
 */
interface NavigationProvider {
    fun navigateUp()

    fun openDetail(user: Result)

    fun openTermAndPrivacy()

    fun openAppLanguage()

    fun openAbout()
}