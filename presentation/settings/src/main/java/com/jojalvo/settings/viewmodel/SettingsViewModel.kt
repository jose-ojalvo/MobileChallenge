package com.jojalvo.settings.viewmodel

import com.jojalvo.framework.base.mvvm.MvvmViewModel
import com.jojalvo.provider.ThemeProvider
import com.jojalvo.provider.ThemeProvider.Theme.DARK
import com.jojalvo.provider.ThemeProvider.Theme.LIGHT
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 *   @author jojalvo
 *   @since 22/4/23
 *   @email josealejandro025@gmail.com
 */
@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val themeProvider: ThemeProvider
) : MvvmViewModel() {

    fun isNightMode() = themeProvider.isNightMode()

    fun saveThemeMode(isChecked: Boolean) {
        themeProvider.theme = if (isChecked) DARK else LIGHT
    }
}