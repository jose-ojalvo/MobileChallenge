package com.jojalvo.provider

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.Flow

/**
 *   @author jojalvo
 *   @since 20/4/23
 *   @email josealejandro025@gmail.com
 */
interface ThemeProvider {
    var theme: Theme
    fun observeTheme(): Flow<Theme>

    enum class Theme {
        LIGHT,
        DARK,
        SYSTEM
    }

    fun isNightMode(): Boolean

    fun setNightMode(forceNight: Boolean)
}

@Composable
fun ThemeProvider.shouldUseDarkMode(): Boolean {
    val themePreference = observeTheme().collectAsState(initial = ThemeProvider.Theme.SYSTEM)
    val mode = when (themePreference.value) {
        ThemeProvider.Theme.LIGHT -> false
        ThemeProvider.Theme.DARK -> true
        else -> isSystemInDarkTheme()
    }
    setNightMode(mode)
    return mode
}